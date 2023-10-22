package be.kdg.prog6.ticketing.adapters.out;

import be.kdg.prog6.ticketing.domain.TicketAgeType;
import be.kdg.prog6.ticketing.domain.TicketDurationType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(schema = "ticket", name = "ticket_projection")
@Getter
public class TicketJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @Setter
    private String ticketUUID;

    @Setter
    @NaturalId
    private UUID visitorUUID;

    @Setter
    @Enumerated(EnumType.STRING)
    private TicketDurationType ticketDurationType;

    @Enumerated(EnumType.STRING)
    @Setter
    private TicketAgeType ticketAgeType;

    @Setter
    private LocalDateTime validFrom;
    @Setter
    private LocalDateTime validUntil
            ;
}
