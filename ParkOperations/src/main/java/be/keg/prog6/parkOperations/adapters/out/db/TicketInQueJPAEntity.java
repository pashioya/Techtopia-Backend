package be.keg.prog6.parkOperations.adapters.out.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "ticket_in_que")
@NoArgsConstructor
@Getter
public class TicketInQueJPAEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID uuid;

    @Setter
    UUID ticketUUID;

    @Setter
    UUID queGateUUID;

    @JdbcTypeCode(Types.TIMESTAMP)
    @Setter
    Instant entryTime;

    @JdbcTypeCode(Types.TIMESTAMP)
    @Setter
    Instant exitTime;
}
