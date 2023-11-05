package be.kdg.prog6.parkInformationSystem.ports.out;

import be.kdg.prog6.parkInformationSystem.domain.Attraction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LoadAttractionPort {
    Optional<Attraction> loadAttraction(UUID attractionUUID);

    List<Attraction> loadAttractions();
}
