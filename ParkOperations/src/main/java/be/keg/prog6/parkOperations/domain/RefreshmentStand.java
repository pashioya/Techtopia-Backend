package be.keg.prog6.parkOperations.domain;

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
    private RefreshmentStandStatus refreshmentStandStatus;
    public record RefreshmentStandUUID(UUID uuid) {
    }
}
