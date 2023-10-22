package be.kdg.prog6.parkInformationSystem.ports.out;

import be.kdg.prog6.parkInformationSystem.domain.attraction.Attraction;

import java.util.Optional;
import java.util.UUID;

public interface AttractionProjectionPort {

    Optional<Attraction> loadAttraction(UUID attractionUUID);

    void saveAttraction(Attraction attraction);
}
