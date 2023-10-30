package be.kdg.prog6.common.facades;

import be.kdg.prog6.common.events.Event;

import java.time.LocalDateTime;
import java.util.UUID;

public record TicketCreatedEvent(
        UUID visitor,
        UUID ticket,
        LocalDateTime validFrom,
        LocalDateTime validUntil
) implements Event
{
}
