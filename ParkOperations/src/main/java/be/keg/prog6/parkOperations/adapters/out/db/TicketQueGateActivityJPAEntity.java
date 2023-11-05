package be.keg.prog6.parkOperations.adapters.out.db;

import be.kdg.prog6.common.facades.ticket.TicketAction;
import jakarta.persistence.*;
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
public class TicketQueGateActivityJPAEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @JdbcTypeCode(Types.VARCHAR)
    @Setter
    private UUID ticketUUID;

    @JdbcTypeCode(Types.VARCHAR)
    @Setter
    private UUID queGateUUID;

    @Enumerated(EnumType.STRING)
    @Setter
    private TicketAction ticketAction;

    @Setter
    private Instant time;

    public TicketQueGateActivityJPAEntity(UUID ticketUUID, UUID queGateUUID, TicketAction ticketAction, Instant time){
        this.uuid = UUID.randomUUID();
        this.ticketUUID = ticketUUID;
        this.queGateUUID = queGateUUID;
        this.ticketAction = ticketAction;
        this.time = time;
    }

}
