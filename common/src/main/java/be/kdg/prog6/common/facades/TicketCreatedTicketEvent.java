package be.kdg.prog6.common.facades;

import java.time.LocalDateTime;
import java.util.UUID;

public record TicketCreatedTicketEvent(
        UUID visitor,
        UUID ticket,
        LocalDateTime validFrom,
        LocalDateTime validUntil
) implements TicketEvent
{
}
