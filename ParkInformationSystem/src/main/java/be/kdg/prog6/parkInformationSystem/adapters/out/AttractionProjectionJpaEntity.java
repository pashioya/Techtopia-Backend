package be.kdg.prog6.parkInformationSystem.adapters.out;

import be.kdg.prog6.parkInformationSystem.domain.attraction.AttractionStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.UUID;

@Entity
@Table(schema = "attractions",name = "gpa.attraction_projection")
@Getter
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
    private AttractionStatus status;

    @Setter
    private UUID queGateUUID;

}
