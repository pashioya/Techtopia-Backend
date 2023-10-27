package be.kdg.prog6.entranceGate.adapters.out.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TicketProjectionsRepository extends JpaRepository<TicketProjectionJpaEntity, Long> {

    Optional<TicketProjectionJpaEntity> findByTicketUUID(UUID ticketUUID);
}
