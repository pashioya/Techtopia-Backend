package be.kdg.prog6.common.facades.ticket;

import java.util.UUID;

public record TicketQueGateActivityCreatedEvent(UUID ticket, UUID queGate, TicketAction ticketAction) implements TicketEvent{
}
