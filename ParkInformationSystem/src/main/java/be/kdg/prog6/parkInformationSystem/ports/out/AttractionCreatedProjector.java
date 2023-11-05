package be.kdg.prog6.parkInformationSystem.ports.out;

import be.kdg.prog6.common.facades.attraction.AttractionCreatedEvent;
import be.kdg.prog6.parkInformationSystem.domain.Attraction;

import java.util.Optional;

public interface AttractionCreatedProjector {

    Optional<Attraction> project(AttractionCreatedEvent attractionCreatedEvent);
}
