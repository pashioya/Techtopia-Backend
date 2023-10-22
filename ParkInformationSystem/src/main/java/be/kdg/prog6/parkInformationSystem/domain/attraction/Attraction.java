package be.kdg.prog6.parkInformationSystem.domain.attraction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class Attraction {
    private AttractionUUID attractionUUID;
    private String name;
    private String description;
    private AttractionStatus status;
    private QueGateUUID queGateUUID;

    public record AttractionUUID(UUID uuid) {
    }

    public record QueGateUUID(UUID uuid) {
    }


}
