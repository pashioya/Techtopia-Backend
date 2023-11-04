package be.kdg.prog6.ticketing.adapters.out.db;

import be.kdg.prog6.ticketing.domain.Visitor;
import be.kdg.prog6.ticketing.ports.out.CreateVisitorPort;
import be.kdg.prog6.ticketing.ports.out.LoadVisitorPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Component
public class VisitorDBAdapter implements CreateVisitorPort, LoadVisitorPort {

    private final VisitorRepository visitorRepository;

    @Override
    public void createVisitor(Visitor visitor) {
        VisitorJpaEntity visitorJpaEntity = new VisitorJpaEntity();

        visitorJpaEntity.setVisitorUUID(visitor.getVisitorUUID().uuid());
        visitorJpaEntity.setName(visitor.getName());
        visitorJpaEntity.setAddress(visitor.getAddress());
        visitorJpaEntity.setEmail(visitor.getEmail());
        visitorJpaEntity.setDateOfBirth(visitor.getDateOfBirth());
        visitorRepository.save(visitorJpaEntity);
    }

    @Override
    public Optional<Visitor> loadVisitor(UUID visitorUUID) {
        return visitorRepository.findByVisitorUUID(visitorUUID).map(visitorJpaEntity -> new Visitor(
                new Visitor.VisitorUUID(visitorJpaEntity.getVisitorUUID()),
                visitorJpaEntity.getName(),
                visitorJpaEntity.getAddress(),
                visitorJpaEntity.getEmail(),
                visitorJpaEntity.getDateOfBirth()
        ));
    }
}
