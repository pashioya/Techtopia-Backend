package be.kdg.prog6.parkInformationSystem.core;

import be.kdg.prog6.parkInformationSystem.domain.Attraction;
import be.kdg.prog6.parkInformationSystem.ports.In.LoadAttractionsUseCase;
import be.kdg.prog6.parkInformationSystem.ports.out.LoadAttractionPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DefaultLoadAttractionsUseCase implements LoadAttractionsUseCase {

    private final LoadAttractionPort loadAttractionPort;
    @Override
    public List<Attraction> loadAttractions() {
        return loadAttractionPort.loadAttractions();
    }
}
