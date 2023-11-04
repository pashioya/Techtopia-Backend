package be.keg.prog6.parkOperations.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;


@AllArgsConstructor
@Getter
@Setter
public class TicketInQue {
    private long id;
    private UUID ticketUUID;
    private UUID queGateUUID;
    private Instant entryTime;
    private Instant exitTime;

    public TicketInQue(UUID ticketUUID, UUID queGateUUID) {
        this.ticketUUID = ticketUUID;
        this.queGateUUID = queGateUUID;
        this.entryTime = Instant.now();
        this.exitTime = null;
    }
}
