package be.kdg.prog6.entranceGate.adapters.out.db;

import be.kdg.prog6.entranceGate.domain.ScannedTicket;
import be.kdg.prog6.entranceGate.domain.TicketActivityEvent;
import be.kdg.prog6.entranceGate.ports.out.ScannedTicketActivityPort;
import be.kdg.prog6.entranceGate.ports.out.ScannedTicketProjectionPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
@AllArgsConstructor
public class TicketProjectionDBAdapter implements ScannedTicketActivityPort, ScannedTicketProjectionPort {

    private final TicketProjectionsRepository ticketProjectionsRepository;

    @Override
    public Optional<ScannedTicket> loadScannedTicket(UUID ticketUUID) {
        Optional<TicketProjectionJpaEntity> ticketJpaEntity = ticketProjectionsRepository.findByTicketUUID(ticketUUID);

        if (ticketJpaEntity.isPresent()) {
            ScannedTicket scannedTicket= new ScannedTicket(
                    new ScannedTicket.TicketUUID(ticketJpaEntity.get().getTicketUUID()),
                    ticketJpaEntity.get().getValidFrom(),
                    ticketJpaEntity.get().getValidUntil()
            );
            return Optional.of(scannedTicket);
        }
        return Optional.empty();
    }

    @Override
    public void saveScannedTicket(ScannedTicket scannedTicket) {

    }

    @Override
    public void saveState(TicketActivityEvent ticketActivityEvent) {

    }
}
