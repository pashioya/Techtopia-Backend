package be.keg.prog6.parkOperations.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
@ToString
public class QueGate {
    private QueGateUUID queGateUUID;
    private int maxCapacity;
    private int currentCapacity;
    private Duration averageWaitTime;
    private AttractionUUID attractionUUID;
    private List<TicketsInQue> ticketsInQueue;

    public record TicketsInQue(UUID ticketUUID, Instant entryTime) {
    }

    public record QueGateUUID(UUID uuid) {
    }

    public record AttractionUUID(UUID uuid) {
    }

    public boolean isFull() {
        return currentCapacity >= maxCapacity;
    }

    public void calculateAverageWaitTime() {
        if (ticketsInQueue.isEmpty()) {
            return; // No wait times recorded
        }

        List<Long> allWaitTimes = new ArrayList<>();
        Instant now = Instant.now();
        ticketsInQueue.forEach(ticketsInQue -> {
            Duration waitTime = Duration.between(ticketsInQue.entryTime(), now);
            allWaitTimes.add(waitTime.toMinutes());
        });

        // Calculate the average wait time for all tickets
        long totalWaitTime = allWaitTimes.stream().mapToLong(Long::longValue).sum();
        long averageMinutes = totalWaitTime / allWaitTimes.size();
        averageWaitTime = Duration.ofMinutes(averageMinutes);
    }
}
