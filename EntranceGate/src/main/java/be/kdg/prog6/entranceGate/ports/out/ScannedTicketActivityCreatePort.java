package be.kdg.prog6.entranceGate.ports.out;

import be.kdg.prog6.entranceGate.domain.ScannedTicket;
import be.kdg.prog6.entranceGate.domain.TicketActivity;

public interface ScannedTicketActivityCreatePort {

    void createScannedTicketActivity(ScannedTicket.TicketUUID ticketUUID, TicketActivity ticketActivity);
}
