package be.keg.prog6.parkOperations.adapters.out.db;

import be.kdg.prog6.common.facades.ticket.TicketAction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "ticket_que_gate_activity")
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class TicketQueGateActivityJPAEntity {

    @Id
    @JdbcTypeCode(Types.VARCHAR)
    private UUID ticketUUID;

    @JdbcTypeCode(Types.VARCHAR)
    private UUID queGateUUID;

    @Enumerated(EnumType.STRING)
    private TicketAction ticketAction;

    @Setter
    private Instant time;
}
