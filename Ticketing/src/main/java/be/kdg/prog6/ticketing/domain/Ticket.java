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


    private TicketDurationType ticketDurationType;
    private TicketAgeType ticketAgeType;
    private LocalDateTime validFrom;
    private LocalDateTime validUntil;

    private TicketUUID ticketUUID;
    private VisitorUUID visitorUUID;

    public record TicketUUID(UUID uuid){
    }

    public record VisitorUUID(UUID uuid){
    }

    public boolean isTicketValid() {
        return LocalDateTime.now().isAfter(validFrom) && LocalDateTime.now().isBefore(validUntil);
    }
}
