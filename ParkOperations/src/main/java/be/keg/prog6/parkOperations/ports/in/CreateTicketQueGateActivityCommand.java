package be.keg.prog6.parkOperations.ports.in;

import be.kdg.prog6.common.facades.ticket.TicketAction;

import java.util.UUID;

public record CreateTicketQueGateActivityCommand(
        UUID ticketUUID,
        UUID queGateUUID,
        TicketAction ticketAction
) {
}
