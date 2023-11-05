package be.keg.prog6.parkOperations.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class Attraction {
    private AttractionUUID attractionUUID;
    private String name;
    private String description;
    private Point location;
    private QueGateUUID queGateUUID;

    public record AttractionUUID(UUID uuid) {
    }

    public record QueGateUUID(UUID uuid) {
    }

    public Attraction(UUID attractionUUID,String name, String description, Point location, UUID queGateUUID) {
        this(new AttractionUUID(attractionUUID),
                name,
                description,
                location,
                new QueGateUUID(queGateUUID));
    }


}
