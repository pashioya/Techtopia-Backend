package be.kdg.prog6.parkInformationSystem.adapters.out;

import be.kdg.prog6.parkInformationSystem.domain.Attraction;
import be.kdg.prog6.parkInformationSystem.ports.out.CreateAttractionPort;
import be.kdg.prog6.parkInformationSystem.ports.out.LoadAttractionPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class AttractionProjectionDBAdapter implements LoadAttractionPort, CreateAttractionPort {

    private final AttractionProjectionRepository attractionProjectionRepository;

    @Override
    public Optional<Attraction> loadAttraction(UUID attractionUUID) {
        Optional<AttractionProjectionJpaEntity> attractionJpaEntity = attractionProjectionRepository.findByAttractionUUID(attractionUUID);
        if(attractionJpaEntity.isPresent()){
            Attraction attraction = new Attraction(new Attraction.AttractionUUID(attractionUUID),
                    attractionJpaEntity.get().getName(),
                    attractionJpaEntity.get().getDescription(),
                    attractionJpaEntity.get().getCurrentCapacity(),
                    attractionJpaEntity.get().getMaxCapacity(),
                    attractionJpaEntity.get().getAverageWaitTime(),
                    attractionJpaEntity.get().getLocation()
            );
            return Optional.of(attraction);
        }

        return Optional.empty();
    }

    @Override
    public List<Attraction> loadAttractions() {
        return attractionProjectionRepository.findAll().stream().map(
                attractionProjectionJpaEntity -> new Attraction(
                        new Attraction.AttractionUUID(attractionProjectionJpaEntity.getAttractionUUID()),
                        attractionProjectionJpaEntity.getName(),
                        attractionProjectionJpaEntity.getDescription(),
                        attractionProjectionJpaEntity.getCurrentCapacity(),
                        attractionProjectionJpaEntity.getMaxCapacity(),
                        attractionProjectionJpaEntity.getAverageWaitTime(),
                        attractionProjectionJpaEntity.getLocation()
                )
        ).toList();
    }

    @Override
    public void createAttraction(Attraction attraction) {
        AttractionProjectionJpaEntity attractionProjectionJpaEntity = new AttractionProjectionJpaEntity();

        attractionProjectionJpaEntity.setAttractionUUID(attraction.getAttractionUUID().uuid());
        attractionProjectionJpaEntity.setName(attraction.getName());
        attractionProjectionJpaEntity.setDescription(attraction.getDescription());
        attractionProjectionJpaEntity.setCurrentCapacity(attraction.getCurrentCapacity());
        attractionProjectionJpaEntity.setMaxCapacity(attraction.getMaxCapacity());
        attractionProjectionJpaEntity.setAverageWaitTime(attraction.getAverageWaitTime());
        attractionProjectionJpaEntity.setLocation(attraction.getLocation());

        attractionProjectionRepository.save(attractionProjectionJpaEntity);
    }
}
