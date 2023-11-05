package be.keg.prog6.parkOperations.domain;

import lombok.*;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class QueGate {
    private QueGateUUID queGateUUID;
    private int maxCapacity;
    private int currentCapacity;
    private Duration averageWaitTime;
    private AttractionUUID attractionUUID;
    private List<TicketInQue> ticketsInQue;

    public record QueGateUUID(UUID uuid) {
    }

    public record AttractionUUID(UUID uuid) {
    }
}
