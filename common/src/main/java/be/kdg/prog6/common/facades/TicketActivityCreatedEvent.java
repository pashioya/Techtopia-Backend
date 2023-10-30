package be.kdg.prog6.common.facades;

import java.time.LocalDateTime;
import java.util.UUID;

public record TicketActivityCreatedEvent(
        UUID uuid,
        UUID ticket,
        LocalDateTime time,
        TicketAction action

) {
}
