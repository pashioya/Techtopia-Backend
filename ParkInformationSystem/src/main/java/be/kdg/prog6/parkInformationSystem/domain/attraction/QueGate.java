package be.kdg.prog6.parkInformationSystem.domain.attraction;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class QueGate {
    private QueGateUUID queGateUUID;
    private String name;
    private String description;
    private int maxCapacity;
    private int currentCapacity;
    private QueGateStatus status;
    private Attraction.AttractionUUID attractionUUID;

    public record QueGateUUID(String uuid) {
    }
}
