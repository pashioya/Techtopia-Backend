package be.kdg.prog6.entranceGate.adapters.out.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ScannedTicketActivityRepository extends JpaRepository<ScannedTicketJpaActivity, UUID> {

    List<ScannedTicketJpaActivity> findByScannedTicket (UUID ticketUUID);
}
