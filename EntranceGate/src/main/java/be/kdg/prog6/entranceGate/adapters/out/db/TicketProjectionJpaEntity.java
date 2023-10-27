package be.kdg.prog6.entranceGate.adapters.out.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(schema = "entrancegate", name = "eg.ticketprojection")
@Getter
public class TicketProjectionJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @Setter
    private UUID ticketUUID;

    @Setter
    @NaturalId
    private UUID visitorUUID;

    @Setter
    private LocalDateTime validFrom;

    @Setter
    private LocalDateTime validUntil;
}
