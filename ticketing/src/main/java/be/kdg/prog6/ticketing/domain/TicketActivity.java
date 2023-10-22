package be.kdg.prog6.ticketing.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public record TicketActivity(UUID ticketUUID, TicketAction ticketAction, LocalDateTime timestamp) {
}
