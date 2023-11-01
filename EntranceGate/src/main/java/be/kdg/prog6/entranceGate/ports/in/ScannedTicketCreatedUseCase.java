package be.kdg.prog6.entranceGate.ports.in;

import be.kdg.prog6.common.facades.TicketCreatedTicketEvent;
import jakarta.transaction.Transactional;

public interface ScannedTicketCreatedUseCase {

    @Transactional
    void createTicket(TicketCreatedTicketEvent event);
}
