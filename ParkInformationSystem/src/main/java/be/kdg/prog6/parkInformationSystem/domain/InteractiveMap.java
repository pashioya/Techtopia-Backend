package be.kdg.prog6.parkInformationSystem.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class InteractiveMap {

    List<Attraction> attractions;
    List<RefreshmentStand> refreshmentStands;
    List<PointOfInterest> pointsOfInterest;


}
