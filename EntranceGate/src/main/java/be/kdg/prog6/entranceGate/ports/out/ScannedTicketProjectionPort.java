package be.kdg.prog6.entranceGate.ports.out;

import be.kdg.prog6.entranceGate.domain.ScannedTicket;

import java.util.Optional;
import java.util.UUID;

public interface ScannedTicketProjectionPort {

    Optional<ScannedTicket> loadScannedTicket(UUID ticketUUID);

    void saveScannedTicket(ScannedTicket scannedTicket);

}
