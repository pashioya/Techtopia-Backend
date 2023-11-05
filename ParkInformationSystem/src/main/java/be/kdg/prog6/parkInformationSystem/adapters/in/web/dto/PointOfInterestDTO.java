package be.kdg.prog6.parkInformationSystem.adapters.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@AllArgsConstructor
@Getter
@Setter
public class PointOfInterestDTO {
    private String name;
    private String description;
    private Point location;
}
