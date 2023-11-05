package be.kdg.prog6.parkInformationSystem.core;

import be.kdg.prog6.common.facades.attraction.AttractionCreatedEvent;
import be.kdg.prog6.parkInformationSystem.domain.Attraction;
import be.kdg.prog6.parkInformationSystem.ports.out.AttractionCreatedProjector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Optional;

@Service
public class DefaultAttractionCreatedProjector implements AttractionCreatedProjector {

    private final Logger logger= LoggerFactory.getLogger(DefaultAttractionCreatedProjector.class);
    @Override
    public Optional<Attraction> project(AttractionCreatedEvent attractionCreatedEvent) {

        logger.info("AttractionCreatedEvent received: {}", attractionCreatedEvent);
        return Optional.of(
                new Attraction(
                        new Attraction.AttractionUUID(attractionCreatedEvent.attractionUUID()),
                        attractionCreatedEvent.name(),
                        attractionCreatedEvent.description(),
                        0,
                        attractionCreatedEvent.maxCapacity(),
                        Duration.ZERO,
                        attractionCreatedEvent.location()
                )
        );
    }
}
