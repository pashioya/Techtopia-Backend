package be.kdg.prog6.parkInformationSystem.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RefreshmentStand {
    private RefreshmentStandUUID refreshmentStandUUID;
    private String name;
    private String description;
    private RefreshmentStandStatus status;

    public record RefreshmentStandUUID(String uuid) {
    }
}
