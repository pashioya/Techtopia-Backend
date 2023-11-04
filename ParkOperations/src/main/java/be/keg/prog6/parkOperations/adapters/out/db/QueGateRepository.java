package be.keg.prog6.parkOperations.adapters.out.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface QueGateRepository extends JpaRepository<QueGateJPAEntity, UUID> {

    Optional<QueGateJPAEntity> findByQueGateUUID(UUID  uuid);
}