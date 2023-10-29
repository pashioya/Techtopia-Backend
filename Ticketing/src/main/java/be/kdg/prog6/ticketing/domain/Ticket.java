package be.kdg.prog6.ticketing.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class Ticket {
    private TicketUUID ticketUUID;
    private VisitorUUID visitorUUID;

    private TicketDurationType ticketDurationType;
    private TicketAgeType ticketAgeType;
    private LocalDateTime validFrom;
    private LocalDateTime validUntil;

    public record TicketUUID(UUID uuid){
    }

    public record VisitorUUID(UUID uuid){
    }
}
