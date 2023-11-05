package be.kdg.prog6.parkInformationSystem.adapters.out;

import be.kdg.prog6.parkInformationSystem.domain.RefreshmentStandStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;

import java.awt.*;
import java.sql.Types;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "refreshment_stand_projection")
public class RefreshmentStandProjectionJpaEntity {
    @Id
    @JdbcTypeCode(Types.VARCHAR)
    private UUID refreshmentStandUUID;
    private String name;
    private String description;
    private Point location;
    @Enumerated(EnumType.STRING)
    private RefreshmentStandStatus status;
}
