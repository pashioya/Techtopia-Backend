package be.kdg.prog6.parkInformationSystem.adapters.in.web;

import be.kdg.prog6.parkInformationSystem.domain.Attraction;
import be.kdg.prog6.parkInformationSystem.domain.InteractiveMap;
import be.kdg.prog6.parkInformationSystem.ports.In.LoadAttractionsUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AttractionController {
    private final LoadAttractionsUseCase loadAttractionsUseCase;

        @GetMapping("/attractions")
        public InteractiveMap getInteractiveMap() {
            InteractiveMap interactiveMap = new InteractiveMap();

            interactiveMap.setAttractions(
                    loadAttractionsUseCase.loadAttractions()
                            .stream()
                            .map(
                                    attraction -> new Attraction(
                                            attraction.getAttractionUUID(),
                                            attraction.getName(),
                                            attraction.getDescription(),
                                            attraction.getCurrentCapacity(),
                                            attraction.getMaxCapacity(),
                                            attraction.getAverageWaitTime(),
                                            attraction.getLocation()
                                    )
                            )
                            .toList());


            return interactiveMap;
        }
}

