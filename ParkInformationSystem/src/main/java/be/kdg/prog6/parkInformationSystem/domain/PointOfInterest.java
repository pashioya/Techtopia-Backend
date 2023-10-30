package be.kdg.prog6.parkInformationSystem.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class PointOfInterest {

    private PointOfInterestUUID pointOfInterestUUID;
    private String name;
    private String description;

    public record PointOfInterestUUID(String uuid) {
    }
}
