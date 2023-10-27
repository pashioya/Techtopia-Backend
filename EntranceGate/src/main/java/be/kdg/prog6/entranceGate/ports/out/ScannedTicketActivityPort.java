package be.kdg.prog6.entranceGate.ports.out;


import be.kdg.prog6.entranceGate.domain.TicketActivityEvent;

public interface ScannedTicketActivityPort {

    void saveState(TicketActivityEvent ticketActivityEvent);
}
