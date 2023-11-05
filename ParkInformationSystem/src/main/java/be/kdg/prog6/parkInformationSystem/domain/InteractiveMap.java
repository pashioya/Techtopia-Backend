package be.kdg.prog6.parkInformationSystem.domain;

import be.kdg.prog6.parkInformationSystem.adapters.in.web.dto.AttractionDTO;
import be.kdg.prog6.parkInformationSystem.adapters.in.web.dto.PointOfInterestDTO;
import be.kdg.prog6.parkInformationSystem.adapters.in.web.dto.RefreshmentStandDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class InteractiveMap {

    List<AttractionDTO> attractions;
    List<RefreshmentStandDTO> refreshmentStands;
    List<PointOfInterestDTO> pointsOfInterest;


}
