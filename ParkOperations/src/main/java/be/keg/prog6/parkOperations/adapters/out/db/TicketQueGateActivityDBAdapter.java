package be.keg.prog6.parkOperations.adapters.out.db;

import be.keg.prog6.parkOperations.domain.TicketQueGateActivity;
import be.keg.prog6.parkOperations.ports.out.CreateTicketQueGateActivityPort;
import be.keg.prog6.parkOperations.ports.out.LoadTicketQueGateActivityPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class TicketQueGateActivityDBAdapter implements CreateTicketQueGateActivityPort, LoadTicketQueGateActivityPort {

    private final TicketQueGateActivityRepository ticketQueGateActivityRepository;

    @Override
    public void createTicketQueGateActivity(TicketQueGateActivity ticketQueGateActivity) {
        ticketQueGateActivityRepository.save(
                new TicketQueGateActivityJPAEntity(
                        ticketQueGateActivity.ticketUUID(),
                        ticketQueGateActivity.queGateUUID(),
                        ticketQueGateActivity.ticketAction(),
                        ticketQueGateActivity.time()
                )
        );

    }

    @Override
    public List<TicketQueGateActivity> loadTicketQueGateActivitiesForQueGate(UUID queGateUUID) {
        return ticketQueGateActivityRepository.findByQueGateUUID(queGateUUID);
    }
}
