package be.kdg.prog6.parkInformationSystem.adapters.in.web;

import be.kdg.prog6.parkInformationSystem.domain.InteractiveMap;
import be.kdg.prog6.parkInformationSystem.ports.In.LoadAttractionsUseCase;
import be.kdg.prog6.parkInformationSystem.ports.In.LoadRefreshmentStandUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class InteractiveMapController {
    private final LoadAttractionsUseCase loadAttractionsUseCase;
    private final LoadRefreshmentStandUseCase loadRefreshmentStandUseCase;

        @GetMapping("/interactiveMap")
        public InteractiveMap getInteractiveMap() {
            InteractiveMap interactiveMap = new InteractiveMap();

            interactiveMap.setAttractions(loadAttractionsUseCase.loadAttractions());
            interactiveMap.setRefreshmentStands(loadRefreshmentStandUseCase.loadRefreshmentStands());

            return interactiveMap;
        }
}

