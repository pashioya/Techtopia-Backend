package be.keg.prog6.parkOperations.adapters.out.db;

import be.keg.prog6.parkOperations.domain.RefreshmentStandStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.awt.*;
import java.sql.Types;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
@Getter
@ToString
public class RefreshmentStandJPAEntity {
    @Id
    @JdbcTypeCode(Types.VARCHAR)
    private UUID uuid;

    @Setter
    private String name;
    @Setter
    private String description;
    @Setter
    private Point location;

    @Setter
    @Enumerated(EnumType.STRING)
    private RefreshmentStandStatus refreshmentStandStatus;

}
