package be.kdg.prog6.parkInformationSystem.adapters.out;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.time.Duration;

@Entity
@Table(name = "attraction_projection")
@Getter
@NoArgsConstructor
public class AttractionProjectionJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "attraction_uuid")
    @JdbcTypeCode(Types.VARCHAR)
    @Setter
    private String attractionUUID;
    @Setter
    private String name;
    @Setter
    private String description;
    @Setter
    private int currentCapacity;
    @Setter
    private int maxCapacity;
    @Setter
    private Duration averageWaitTime;

}
