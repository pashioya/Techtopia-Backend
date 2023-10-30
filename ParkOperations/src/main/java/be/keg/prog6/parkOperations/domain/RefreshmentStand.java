package be.keg.prog6.parkOperations.domain;

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
    public record RefreshmentStandUUID(String uuid) {
    }
}
