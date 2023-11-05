package be.kdg.prog6.parkInformationSystem.adapters.in.web;

import be.kdg.prog6.parkInformationSystem.adapters.in.web.dto.AttractionDTO;
import be.kdg.prog6.parkInformationSystem.domain.Attraction;
import be.kdg.prog6.parkInformationSystem.ports.In.LoadAttractionsUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class AttractionController {

    private final LoadAttractionsUseCase loadAttractionsUseCase;

     @GetMapping("/attractions")
        public List<AttractionDTO> getAttractions() {
            return loadAttractionsUseCase.loadAttractions().stream().map(Attraction::toDTO).toList();
        }
}
