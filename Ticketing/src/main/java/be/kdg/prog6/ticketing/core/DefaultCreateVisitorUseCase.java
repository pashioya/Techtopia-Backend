package be.kdg.prog6.ticketing.core;

import be.kdg.prog6.ticketing.domain.Visitor;
import be.kdg.prog6.ticketing.ports.in.CreateVisitorCommand;
import be.kdg.prog6.ticketing.ports.in.CreateVisitorUseCase;
import be.kdg.prog6.ticketing.ports.out.CreateVisitorPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class DefaultCreateVisitorUseCase implements CreateVisitorUseCase {

    private final CreateVisitorPort createVisitorPort;

    @Override
    public void createVisitor(CreateVisitorCommand createVisitorCommand) {
        createVisitorPort.createVisitor(
                new Visitor(
                        new Visitor.VisitorUUID(UUID.randomUUID()),
                        createVisitorCommand.name(),
                        createVisitorCommand.address(),
                        createVisitorCommand.email(),
                        createVisitorCommand.dateOfBirth()));
    }
}
