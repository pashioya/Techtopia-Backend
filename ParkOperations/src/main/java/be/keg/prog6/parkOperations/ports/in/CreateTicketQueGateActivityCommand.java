package be.keg.prog6.parkOperations.ports.in;

import be.kdg.prog6.common.facades.ticket.TicketAction;
import lombok.ToString;

import java.util.UUID;

@ToString
public record CreateTicketQueGateActivityCommand(
        UUID ticketUUID,
        UUID queGateUUID,
        TicketAction ticketAction
) {
}
