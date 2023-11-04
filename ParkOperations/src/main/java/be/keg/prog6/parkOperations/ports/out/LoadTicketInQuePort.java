package be.keg.prog6.parkOperations.ports.out;

import be.keg.prog6.parkOperations.domain.TicketInQue;

import java.util.List;
import java.util.UUID;

public interface LoadTicketInQuePort {

    List<TicketInQue> loadTicketsInQueFromTodayByQueUUID(UUID queUUID);
}
