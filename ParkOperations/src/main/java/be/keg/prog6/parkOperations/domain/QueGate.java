package be.keg.prog6.parkOperations.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class QueGate {
    private QueGateUUID queGateUUID;
    private int maxCapacity;
    private int currentCapacity;
    private Duration averageWaitTime;
    private Attraction.AttractionUUID attractionUUID;
    private List<TicketEntry> ticketsInQueue;

    public record QueGateUUID(String uuid) {
    }

    public void increaseCurrentCapacity() {
        currentCapacity++;
    }

    public void decreaseCurrentCapacity() {
        currentCapacity--;
    }

    public boolean isFull() {
        return currentCapacity >= maxCapacity;
    }

    public void ticketEnteredQueue(UUID ticketUUID) {
        if (!isFull()) {
            ticketsInQueue.add(new TicketEntry(ticketUUID, Instant.now()));
            increaseCurrentCapacity();
        }
    }

    public void ticketLeftQueue(UUID ticketUUID) {
        ticketsInQueue.removeIf(ticketEntry -> ticketEntry.ticketUUID().equals(ticketUUID));
        decreaseCurrentCapacity();
        averageWaitTime =  calculateAverageWaitTime();
    }

    public Duration calculateAverageWaitTime() {
        if (ticketsInQueue.isEmpty()) {
            return Duration.ZERO; // No wait times recorded
        }

        List<Duration> allWaitTimes = new ArrayList<>();
        ticketsInQueue.forEach(ticketEntry -> {
            Duration waitTime = Duration.between(ticketEntry.entryTime(), Instant.now());
            allWaitTimes.add(waitTime);
        });

        // Calculate the average wait time for all tickets
        long totalWaitTime = allWaitTimes.stream().mapToLong(Duration::toMinutes).sum();
        long averageWaitTimeMinutes = totalWaitTime / allWaitTimes.size();
        return Duration.ofMinutes(averageWaitTimeMinutes);
    }

    private record TicketEntry(UUID ticketUUID, Instant entryTime) {
    }
}
