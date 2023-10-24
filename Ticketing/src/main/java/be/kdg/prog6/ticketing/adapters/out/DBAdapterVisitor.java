package be.kdg.prog6.ticketing.adapters.out;

import be.kdg.prog6.ticketing.domain.Visitor;
import be.kdg.prog6.ticketing.ports.out.CreateVisitorPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DBAdapterVisitor implements CreateVisitorPort {

    private final VisitorRepository visitorRepository;

    @Override
    public void createVisitor(Visitor visitor) {
        VisitorJpaEntity visitorJpaEntity = new VisitorJpaEntity();

        visitorJpaEntity.setVisitorUUID(visitor.getVisitorUUID().uuid());
        visitorJpaEntity.setName(visitor.getName());
        visitorJpaEntity.setAddress(visitor.getAddress());
        visitorJpaEntity.setEmail(visitor.getEmail());
        visitorJpaEntity.setPhone(visitor.getPhone());

        visitorRepository.save(visitorJpaEntity);
    }
}
