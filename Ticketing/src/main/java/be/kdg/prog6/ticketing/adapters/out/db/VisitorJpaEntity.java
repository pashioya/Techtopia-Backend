package be.kdg.prog6.ticketing.adapters.out.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "visitor", schema = "ticket.visitor")
@Getter
public class VisitorJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @Setter
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID visitorUUID;

    @Setter
    private String name;

    @Setter
    private String address;

    @Setter
    @Column(unique = true)
    private String email;

    @Setter
    private LocalDate dateOfBirth;
}
