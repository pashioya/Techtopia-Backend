package be.keg.prog6.parkOperations.adapters.out.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketInQueRepository extends JpaRepository<TicketInQueJPAEntity, Long> {


    @Query(value = "SELECT * FROM ticket_in_que WHERE que_gate_uuid = ?1 AND entry_time > CURRENT_DATE And exit_time IS NULL", nativeQuery = true)
    List<TicketInQueJPAEntity> findAllFromTodayByQueGateUUID();
}
