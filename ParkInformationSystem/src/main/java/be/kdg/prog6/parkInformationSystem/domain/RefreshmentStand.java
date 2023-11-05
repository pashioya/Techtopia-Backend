package be.kdg.prog6.parkInformationSystem.domain;

import be.kdg.prog6.parkInformationSystem.adapters.in.web.dto.RefreshmentStandDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class RefreshmentStand {
    private RefreshmentStandUUID refreshmentStandUUID;
    private String name;
    private String description;
    private Point location;
    private RefreshmentStandStatus status;

    public RefreshmentStandDTO toDTO() {
        return new RefreshmentStandDTO(name, description, location, status);
    }

    public record RefreshmentStandUUID(UUID uuid) {
    }
}
