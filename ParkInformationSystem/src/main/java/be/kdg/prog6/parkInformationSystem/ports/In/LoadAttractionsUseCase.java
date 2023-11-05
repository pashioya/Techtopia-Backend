package be.kdg.prog6.parkInformationSystem.ports.In;

import be.kdg.prog6.parkInformationSystem.domain.Attraction;

import java.util.List;

public interface LoadAttractionsUseCase {

    List<Attraction> loadAttractions();
}
