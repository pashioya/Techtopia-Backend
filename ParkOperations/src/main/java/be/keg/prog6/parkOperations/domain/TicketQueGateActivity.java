package be.keg.prog6.parkOperations.domain;

import be.kdg.prog6.common.facades.ticket.TicketAction;

import java.time.Instant;
import java.util.UUID;

public record TicketQueGateActivity(
        UUID ticketUUID,
        UUID queGateUUID,
        TicketAction ticketAction,
        Instant time
) {
}
