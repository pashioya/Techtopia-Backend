package be.keg.prog6.parkOperations.adapters.out.db;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.awt.*;
import java.sql.Types;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "attraction")
@Getter
@ToString
public class AttractionJPAEntity {

    @Id
    @JdbcTypeCode(Types.VARCHAR)
    private UUID uuid;

    @Setter
    private String name;

    @Setter
    private String description;

    @Setter
    private Point location;

    @JdbcTypeCode(Types.VARCHAR)
    @Setter
    private UUID queGateUUID;
}
