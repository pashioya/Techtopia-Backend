package be.keg.prog6.parkOperations.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
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


    public QueGate(QueGateUUID queGateUUID, int maxCapacity, AttractionUUID attractionUUID) {
        this.queGateUUID = queGateUUID;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = 0;
        this.averageWaitTime = Duration.ZERO;
        this.attractionUUID = attractionUUID;
        this.ticketsInQue = new ArrayList<>();
    }


    public record QueGateUUID(UUID uuid) {
    }

    public record AttractionUUID(UUID uuid) {
    }
}
