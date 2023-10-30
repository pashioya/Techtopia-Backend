package be.kdg.prog6.entranceGate.adapters.out.db;

import be.kdg.prog6.entranceGate.domain.TicketAction;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(schema = "entrancegate", name = "eg.activities")
@Getter
public class ScannedTicketJpaActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(Types.VARCHAR)
    private UUID uuid;

    @Setter
    @Enumerated(EnumType.STRING)
    private TicketAction ticketAction;

    @JdbcTypeCode(Types.VARCHAR)
    @Setter
    private UUID scannedTicket;

    @JdbcTypeCode(Types.VARCHAR)
    @Setter
    private UUID entranceGate;

    @Setter
    private LocalDateTime pit;

}
