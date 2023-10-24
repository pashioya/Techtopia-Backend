package be.kdg.prog6.ticketing.adapters.out;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TicketRepository extends JpaRepository<TicketJpaEntity, UUID> {
}
