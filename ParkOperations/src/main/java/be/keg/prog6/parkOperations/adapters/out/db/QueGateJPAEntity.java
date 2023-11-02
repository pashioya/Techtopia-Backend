package be.keg.prog6.parkOperations.adapters.out.db;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.time.Duration;
import java.util.UUID;

@Entity
@Table(name = "que_gate")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QueGateJPAEntity {

    @Id
    @JdbcTypeCode(Types.VARCHAR)
    private UUID queGateUUID;

    @Setter
    private int maxCapacity;
    @Setter
    private int currentCapacity;
    @Setter
    private Duration averageWaitTime;
    @Setter
    @JdbcTypeCode(Types.VARCHAR)
    private UUID attractionUUID;
}
