package be.kdg.prog6.entranceGate.ports.in;

import be.kdg.prog6.common.facades.ticket.TicketCreatedEvent;
import jakarta.transaction.Transactional;

public interface ScannedTicketCreatedUseCase {

    @Transactional
    void createTicket(TicketCreatedEvent event);
}
