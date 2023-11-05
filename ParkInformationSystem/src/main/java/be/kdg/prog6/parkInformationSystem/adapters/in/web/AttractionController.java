package be.kdg.prog6.parkInformationSystem.adapters.in.web;

import be.kdg.prog6.parkInformationSystem.ports.In.LoadAttractionsUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AttractionController {
    private final LoadAttractionsUseCase loadAttractionsUseCase;

        @GetMapping("/attractions")
        public List<AttractionDTO> getAttractions() {
            return loadAttractionsUseCase.loadAttractions()
                    .stream()
                    .map(
                            attraction -> new AttractionDTO(
                                    attraction.getName(),
                                    attraction.getDescription(),
                                    attraction.getCurrentCapacity(),
                                    attraction.getMaxCapacity(),
                                    attraction.getAverageWaitTime()
                            )
                    )
                    .toList();
        }
}

