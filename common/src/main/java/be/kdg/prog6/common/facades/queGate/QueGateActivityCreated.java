package be.kdg.prog6.common.facades.queGate;

import be.kdg.prog6.common.facades.ticket.TicketAction;

import java.util.UUID;

public record QueGateActivityCreated(
        UUID ticketUUID,
        UUID attractionUUID,
        TicketAction ticketAction
) implements QueGateEvent{
}
