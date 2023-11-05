package be.keg.prog6.parkOperations.adapters.out.db;

import be.keg.prog6.parkOperations.domain.TicketInQue;
import be.keg.prog6.parkOperations.ports.out.CreateTicketInQuePort;
import be.keg.prog6.parkOperations.ports.out.LoadTicketInQuePort;
import be.keg.prog6.parkOperations.ports.out.UpdateTicketInQuePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class TicketInQueDBAdapter implements CreateTicketInQuePort, LoadTicketInQuePort, UpdateTicketInQuePort {

    private final TicketInQueRepository ticketInQueRepository;
    

    @Override
    public void createTicketInQue(TicketInQue ticketInQue) {
        TicketInQueJPAEntity ticketInQueJPAEntity = new TicketInQueJPAEntity();

        ticketInQueJPAEntity.setQueGateUUID(ticketInQue.getQueGateUUID());
        ticketInQueJPAEntity.setTicketUUID(ticketInQue.getTicketUUID());
        ticketInQueJPAEntity.setEntryTime(ticketInQue.getEntryTime());
        ticketInQueJPAEntity.setExitTime(ticketInQue.getExitTime());

        ticketInQueRepository.save(ticketInQueJPAEntity);
    }

    @Override
    public List<TicketInQue> loadTicketsInQueFromTodayByQueUUID(UUID queUUID) {
        return  ticketInQueRepository.findAllFromTodayByQueGateUUID(queUUID).stream().map(
                ticketInQueJPAEntity -> new TicketInQue(
                        ticketInQueJPAEntity.getUuid(),
                        ticketInQueJPAEntity.getTicketUUID(),
                        ticketInQueJPAEntity.getQueGateUUID(),
                        ticketInQueJPAEntity.getEntryTime(),
                        ticketInQueJPAEntity.getExitTime()
                )
        ).toList();
    }

    @Override
    public List<TicketInQue> loadCheckedOutTicketsInQueFromTodayByQueUUID(UUID queUUID) {
        return  ticketInQueRepository.findAllCheckedOutTicketsFromTodayBYQueGateUUID(queUUID).stream().map(
                ticketInQueJPAEntity -> new TicketInQue(
                        ticketInQueJPAEntity.getUuid(),
                        ticketInQueJPAEntity.getTicketUUID(),
                        ticketInQueJPAEntity.getQueGateUUID(),
                        ticketInQueJPAEntity.getEntryTime(),
                        ticketInQueJPAEntity.getExitTime()
                )
        ).toList();
    }

    @Override
    public void updateTicketInQue(TicketInQue ticketInQue) {
        ticketInQueRepository.findById(ticketInQue.getUuid()).ifPresent(
                ticketInQueJPAEntity -> {
                    ticketInQueJPAEntity.setExitTime(ticketInQue.getExitTime());
                    ticketInQueRepository.save(ticketInQueJPAEntity);
                }
        );
    }
}
