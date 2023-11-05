package be.keg.prog6.parkOperations.adapters.out.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface TicketInQueRepository extends JpaRepository<TicketInQueJPAEntity, UUID> {


    @Query(value = "SELECT * FROM ticket_in_que WHERE que_gateuuid = ?1 AND entry_time > CURRENT_DATE And exit_time IS NULL", nativeQuery = true)
    List<TicketInQueJPAEntity> findAllFromTodayByQueGateUUID(UUID queUUID);

    @Query(value = "SELECT * FROM ticket_in_que WHERE que_gateuuid = ?1 AND entry_time > CURRENT_DATE And exit_time is not null", nativeQuery = true)
    List<TicketInQueJPAEntity> findAllCheckedOutTicketsFromTodayBYQueGateUUID(UUID queuuid);
}
