package be.kdg.prog6.entranceGate.adapters.out.db;

import be.kdg.prog6.entranceGate.domain.ActivityWindow;
import be.kdg.prog6.entranceGate.domain.ScannedTicket;
import be.kdg.prog6.entranceGate.domain.TicketActivity;
import be.kdg.prog6.entranceGate.ports.out.ScannedTicketActivityCreatePort;
import be.kdg.prog6.entranceGate.ports.out.ScannedTicketProjectionPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
@AllArgsConstructor
public class ScannedTicketProjectionDBAdapter implements ScannedTicketProjectionPort, ScannedTicketActivityCreatePort {


    private final ScannedTicketProjectionsRepository scannedTicketProjectionsRepository;
    private final ScannedTicketActivityRepository scannedTicketActivityRepository;

    @Override
    public Optional<ScannedTicket> loadScannedTicket(UUID ticketUUID) {
        Optional<ScannedTicketProjectionJpaEntity> ticketJpaEntity = scannedTicketProjectionsRepository.findByTicketUUID(ticketUUID);

        if (ticketJpaEntity.isPresent()) {
            ScannedTicket scannedTicket= new ScannedTicket(
                    new ScannedTicket.TicketUUID(ticketJpaEntity.get().getTicketUUID()),
                    ticketJpaEntity.get().getValidFrom(),
                    ticketJpaEntity.get().getValidUntil(),
                    new ActivityWindow()
            );

            List<ScannedTicketJpaActivity> scannedTicketJpaActivityList = scannedTicketActivityRepository.findByScannedTicket(scannedTicket.getTicketUUID().uuid());

            for (ScannedTicketJpaActivity scannedTicketJpaActivity : scannedTicketJpaActivityList) {
                scannedTicket.getActivityWindow().add(
                        new TicketActivity(
                                scannedTicketJpaActivity.getTicketAction(),
                                scannedTicketJpaActivity.getPit()
                        )
                );
            }

            return Optional.of(scannedTicket);
        }
        return Optional.empty();
    }

    @Override
    public void saveScannedTicket(ScannedTicket scannedTicket) {
        ScannedTicketProjectionJpaEntity scannedTicketProjectionJpaEntity = new ScannedTicketProjectionJpaEntity();
        scannedTicketProjectionJpaEntity.setTicketUUID(scannedTicket.getTicketUUID().uuid());
        scannedTicketProjectionJpaEntity.setValidFrom(scannedTicket.getValidFrom());
        scannedTicketProjectionJpaEntity.setValidUntil(scannedTicket.getValidUntil());
        scannedTicketProjectionsRepository.save(scannedTicketProjectionJpaEntity);
    }

    @Override
    public void createScannedTicketActivity(ScannedTicket.TicketUUID ticketUUID, TicketActivity ticketActivity) {
        ScannedTicketJpaActivity scannedTicketJpaActivity = new ScannedTicketJpaActivity();
        scannedTicketJpaActivity.setScannedTicket(ticketUUID.uuid());
        scannedTicketJpaActivity.setTicketAction(ticketActivity.action());
        scannedTicketJpaActivity.setPit(ticketActivity.pit());
        scannedTicketActivityRepository.save(scannedTicketJpaActivity);
    }
}
