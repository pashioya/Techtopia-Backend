package be.kdg.prog6.parkInformationSystem.adapters.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.time.Duration;

@AllArgsConstructor
@Getter
@Setter
public class AttractionDTO {

    private String name;
    private String description;
    private int currentCapacity;
    private int maxCapacity;
    private Duration averageWaitTime;
    private Point location;
}
