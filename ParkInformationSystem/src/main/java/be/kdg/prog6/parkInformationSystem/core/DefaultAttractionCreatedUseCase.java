package be.kdg.prog6.parkInformationSystem.core;

import be.kdg.prog6.common.facades.attraction.AttractionCreatedEvent;
import be.kdg.prog6.parkInformationSystem.domain.Attraction;
import be.kdg.prog6.parkInformationSystem.ports.In.AttractionCreatedUseCase;
import be.kdg.prog6.parkInformationSystem.ports.out.AttractionCreatedProjector;
import be.kdg.prog6.parkInformationSystem.ports.out.CreateAttractionPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DefaultAttractionCreatedUseCase implements AttractionCreatedUseCase {

    private final AttractionCreatedProjector attractionCreatedProjector;
    private final CreateAttractionPort createAttractionPort;



    @Override
    public void createAttraction(AttractionCreatedEvent attractionCreatedEvent) {
        Optional<Attraction> attraction = attractionCreatedProjector.project(attractionCreatedEvent);
        attraction.ifPresent(createAttractionPort::createAttraction);
    }
}
