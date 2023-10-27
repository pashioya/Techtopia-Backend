package be.kdg.prog6.ticketing.core;

import be.kdg.prog6.ticketing.domain.Visitor;
import be.kdg.prog6.ticketing.ports.in.CreateVisitorUseCase;
import be.kdg.prog6.ticketing.ports.out.CreateVisitorPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DefaultCreateVisitorUseCase implements CreateVisitorUseCase {

    private final CreateVisitorPort createVisitorPort;

    @Override
    public void createVisitor(Visitor visitor) {
        createVisitorPort.createVisitor(
                visitor
        );
    }
}
