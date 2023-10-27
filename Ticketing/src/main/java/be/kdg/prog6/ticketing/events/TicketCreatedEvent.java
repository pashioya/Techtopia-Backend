package be.kdg.prog6.ticketing.events;

import java.util.UUID;

public record TicketCreatedEvent(
        UUID visitor,
        UUID ticket
) {
}
