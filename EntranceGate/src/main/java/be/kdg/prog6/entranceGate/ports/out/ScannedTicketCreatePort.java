package be.kdg.prog6.entranceGate.ports.out;

import be.kdg.prog6.entranceGate.domain.ScannedTicket;

public interface ScannedTicketCreatePort {

    void createScannedTicket(ScannedTicket scannedTicket);
}
