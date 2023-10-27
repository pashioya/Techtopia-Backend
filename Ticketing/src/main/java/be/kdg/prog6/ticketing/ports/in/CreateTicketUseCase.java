package be.kdg.prog6.ticketing.ports.in;

import be.kdg.prog6.ticketing.domain.Ticket;

public interface CreateTicketUseCase {

    void createTicket(Ticket ticket);
}
