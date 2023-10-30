package be.keg.prog6.parkOperations.domain;

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
    private QueGateUUID queGateUUID;

    public record AttractionUUID(UUID uuid) {
    }

    public record QueGateUUID(UUID uuid) {
    }


}
