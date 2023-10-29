package be.kdg.prog6.entranceGate.adapters.out.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ScannedTicketProjectionsRepository extends JpaRepository<ScannedTicketProjectionJpaEntity, Long> {

    Optional<ScannedTicketProjectionJpaEntity> findByTicketUUID(UUID ticketUUID);
}
