package be.kdg.prog6.parkInformationSystem.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Setter
@Getter
public class PointOfInterest {

    private PointOfInterestUUID pointOfInterestUUID;


    public record PointOfInterestUUID(String uuid) {
    }
}
