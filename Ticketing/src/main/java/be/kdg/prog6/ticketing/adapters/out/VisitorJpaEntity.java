package be.kdg.prog6.ticketing.adapters.out;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import java.util.UUID;

@Entity
@Table(name = "visitor_projection", schema = "ticket")
@Getter
public class VisitorJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @Setter
    private UUID visitorUUID;

    @Setter
    private String name;

    @Setter
    private String address;

    @Setter
    private String email;

    @Setter
    private String phone;
}
