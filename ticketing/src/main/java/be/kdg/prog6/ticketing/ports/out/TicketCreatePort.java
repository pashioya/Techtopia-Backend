package be.kdg.prog6.ticketing.ports.out;

import be.kdg.prog6.ticketing.domain.Ticket;

public interface TicketCreatePort {

    void createTicket(Ticket ticket);
}
