package be.kdg.prog6.ticketing.ports.in;

import be.kdg.prog6.ticketing.domain.Ticket;

public record CreateTicketCommand( Ticket ticket) {
}
