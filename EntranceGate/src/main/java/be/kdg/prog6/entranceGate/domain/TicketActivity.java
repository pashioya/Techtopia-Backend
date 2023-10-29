package be.kdg.prog6.entranceGate.domain;

import java.time.LocalDateTime;

public record TicketActivity(TicketAction action, LocalDateTime pit) {
}
