package be.kdg.prog6.parkInformationSystem.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.time.Duration;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class Attraction {
    private AttractionUUID attractionUUID;
    private String name;
    private String description;
    private int currentCapacity;
    private int maxCapacity;
    private Duration averageWaitTime;
    private Point location;
    public record AttractionUUID(UUID uuid) {
    }
}
