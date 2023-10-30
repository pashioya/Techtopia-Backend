package be.kdg.prog6.ticketing.ports.in;

import be.kdg.prog6.ticketing.domain.TicketAgeType;
import be.kdg.prog6.ticketing.domain.TicketDurationType;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateTicketCommand(UUID visitor, TicketDurationType durationType, TicketAgeType ageType,
                                  LocalDateTime validFrom, LocalDateTime validUntil) {
}
