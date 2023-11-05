package be.kdg.prog6.parkInformationSystem.ports.In;

import be.kdg.prog6.common.facades.attraction.AttractionCreatedEvent;

public interface AttractionCreatedUseCase {

    void createAttraction(AttractionCreatedEvent attractionCreatedEvent);
}
