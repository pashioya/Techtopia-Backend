package be.kdg.prog6.entranceGate.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public record TicketActivityEvent(UUID ticketUUID, TicketAction action, LocalDateTime pit) {
}
