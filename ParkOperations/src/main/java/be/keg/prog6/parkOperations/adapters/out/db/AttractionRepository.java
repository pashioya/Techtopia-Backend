package be.keg.prog6.parkOperations.adapters.out.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AttractionRepository extends JpaRepository<AttractionJPAEntity, UUID> {

}
