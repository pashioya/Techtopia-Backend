package be.kdg.prog6.parkInformationSystem.domain;

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
    public record AttractionUUID(UUID uuid) {
    }
}
