package be.keg.prog6.parkOperations.adapters.out.db;

import be.keg.prog6.parkOperations.domain.TicketQueGateActivity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TicketQueGateActivityRepository extends JpaRepository<TicketQueGateActivityJPAEntity, UUID>{
    List<TicketQueGateActivity> findByQueGateUUID(UUID queGateUUID);
}
