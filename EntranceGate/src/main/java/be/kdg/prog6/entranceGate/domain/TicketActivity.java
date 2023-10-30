package be.kdg.prog6.entranceGate.domain;

import be.kdg.prog6.common.facades.TicketAction;

import java.time.LocalDateTime;
import java.util.UUID;

public record TicketActivity(UUID uuid,TicketAction action, UUID entranceGate, LocalDateTime pit) {
}
