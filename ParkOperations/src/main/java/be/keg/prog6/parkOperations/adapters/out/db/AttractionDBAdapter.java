package be.keg.prog6.parkOperations.adapters.out.db;

import be.keg.prog6.parkOperations.domain.Attraction;
import be.keg.prog6.parkOperations.ports.out.CreateAttractionPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class AttractionDBAdapter implements CreateAttractionPort {

    private final AttractionRepository attractionRepository;
    @Override
    public void createAttraction(Attraction attraction) {
        attractionRepository.save(new AttractionJPAEntity(
                attraction.getAttractionUUID().uuid(),
                attraction.getName(),
                attraction.getDescription(),
                attraction.getLocation(),
                attraction.getQueGateUUID().uuid()
                )
        );
    }
}
