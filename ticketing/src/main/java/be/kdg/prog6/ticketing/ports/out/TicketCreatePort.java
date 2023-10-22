package be.kdg.prog6.ticketing.ports.out;

import be.kdg.prog6.ticketing.domain.Ticket;
import be.kdg.prog6.ticketing.domain.Visitor;

public interface TicketCreatePort {

    void createTicket(Visitor.VisitorUUID visitorUUID, Ticket ticket);
}
