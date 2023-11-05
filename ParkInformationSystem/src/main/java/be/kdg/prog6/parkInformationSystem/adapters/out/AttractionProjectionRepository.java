package be.kdg.prog6.parkInformationSystem.adapters.out;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AttractionProjectionRepository
        extends JpaRepository<AttractionProjectionJpaEntity, Long>{

    Optional<AttractionProjectionJpaEntity> findByAttractionUUID(UUID attractionUUID);

}
