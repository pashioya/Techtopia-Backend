package be.kdg.prog6.ticketing.adapters.in.web.dto;

import be.kdg.prog6.ticketing.domain.TicketAgeType;
import be.kdg.prog6.ticketing.domain.TicketDurationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class CreateTicketDTO {
    private TicketDurationType ticketDurationType;
    private TicketAgeType ticketAgeType;
    private LocalDateTime validFrom;
    private LocalDateTime validUntil;
}
