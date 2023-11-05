package be.kdg.prog6.parkInformationSystem.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@AllArgsConstructor
@Setter
@Getter
public class PointOfInterest {

    private PointOfInterestUUID pointOfInterestUUID;
    private String name;
    private String description;
    private Point location;

    public record PointOfInterestUUID(String uuid) {
    }
}
