package be.keg.prog6.parkOperations.ports.out;

import be.keg.prog6.parkOperations.domain.TicketQueGateActivity;

import java.util.List;
import java.util.UUID;

public interface LoadTicketQueGateActivityPort {
    List<TicketQueGateActivity> loadTicketQueGateActivitiesForQueGate(UUID queGateUUID);
}
