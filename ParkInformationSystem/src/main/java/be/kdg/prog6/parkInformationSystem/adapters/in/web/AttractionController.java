package be.kdg.prog6.parkInformationSystem.adapters.in.web;

import be.kdg.prog6.parkInformationSystem.ports.In.LoadAttractionsUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class AttractionController {

    private final LoadAttractionsUseCase loadAttractionsUseCase;

     @GetMapping("/attractions")
        public String getAttractions() {
            return loadAttractionsUseCase.loadAttractions().toString();
        }
}
