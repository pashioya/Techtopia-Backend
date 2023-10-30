package be.keg.prog6.parkOperations.domain;

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
    private Attraction.AttractionUUID attractionUUID;

    public record QueGateUUID(String uuid) {
    }
}
