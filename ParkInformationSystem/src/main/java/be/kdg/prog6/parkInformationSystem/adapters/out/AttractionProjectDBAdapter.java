package be.kdg.prog6.parkInformationSystem.adapters.out;

import be.kdg.prog6.parkInformationSystem.domain.attraction.Attraction;
import be.kdg.prog6.parkInformationSystem.ports.out.AttractionProjectionPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class AttractionProjectDBAdapter implements AttractionProjectionPort {

    private final AttractionProjectionRepository attractionProjectionRepository;

    @Override
    public Optional<Attraction> loadAttraction(UUID attractionUUID) {
        Optional<AttractionProjectionJpaEntity> attractionJpaEntity = attractionProjectionRepository.findByAttractionUUID(String.valueOf(attractionUUID));
        if(attractionJpaEntity.isPresent()){
            Attraction attraction = new Attraction(new Attraction.AttractionUUID(attractionUUID),
                    attractionJpaEntity.get().getName(),
                    attractionJpaEntity.get().getDescription(),
                    attractionJpaEntity.get().getStatus(),
                    new Attraction.QueGateUUID(attractionJpaEntity.get().getQueGateUUID()));
            return Optional.of(attraction);
        }

        return Optional.empty();
    }

    @Override
    public void saveAttraction(Attraction attraction) {

    }
}
