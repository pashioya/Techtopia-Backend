package be.kdg.prog6.parkInformationSystem.adapters.in.web.dto;

import be.kdg.prog6.parkInformationSystem.domain.RefreshmentStandStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@AllArgsConstructor
@Getter
@Setter
public class RefreshmentStandDTO {
    private String name;
    private String description;
    private Point location;
    private RefreshmentStandStatus status;
}
