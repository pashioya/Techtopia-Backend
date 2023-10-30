package be.kdg.prog6.entranceGate.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public record TicketActivity(TicketAction action, UUID entranceGate, LocalDateTime pit) {
}
