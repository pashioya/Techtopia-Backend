package be.kdg.prog6.entranceGate.ports.out;

import be.kdg.prog6.common.facades.TicketCreatedEvent;
import be.kdg.prog6.entranceGate.domain.ScannedTicket;

import java.util.Optional;

public interface ScannedTicketCreatedProjector {

    Optional<ScannedTicket> project(TicketCreatedEvent ticketCreatedEvent);
}
