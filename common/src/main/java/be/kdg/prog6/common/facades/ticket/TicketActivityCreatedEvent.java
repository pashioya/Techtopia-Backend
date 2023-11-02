package be.kdg.prog6.common.facades.ticket;

import java.time.LocalDateTime;
import java.util.UUID;

public record TicketActivityCreatedEvent(
        UUID uuid,
        UUID ticket,
        LocalDateTime time,
        TicketAction action

) implements TicketEvent
{
}
