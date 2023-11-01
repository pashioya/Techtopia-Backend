package be.kdg.prog6.ticketing.core;

import be.kdg.prog6.ticketing.domain.Ticket;
import be.kdg.prog6.ticketing.domain.Visitor;
import be.kdg.prog6.ticketing.ports.in.CreateTicketCommand;
import be.kdg.prog6.ticketing.ports.in.CreateTicketUseCase;
import be.kdg.prog6.ticketing.ports.out.CreateTicketPort;
import be.kdg.prog6.ticketing.ports.out.LoadVisitorPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class DefaultCreateTicketUseCase implements CreateTicketUseCase{

    private final List<CreateTicketPort> createTicketPorts;
    private final LoadVisitorPort loadVisitorPort;

    @Override
    public void createTicket(CreateTicketCommand createTicketCommand) {

        Optional<Visitor> visitor = loadVisitorPort.loadVisitor(createTicketCommand.visitor());
        if (visitor.isPresent()) {
            createTicketPorts.forEach(createTicketPort -> createTicketPort
                    .ticketCreated(
                            new Ticket(
                                    new Ticket.TicketUUID(UUID.randomUUID()),
                                    new Ticket.VisitorUUID(createTicketCommand.visitor()),
                                    createTicketCommand.durationType(),
                                    createTicketCommand.ageType(),
                                    createTicketCommand.validFrom(),
                                    createTicketCommand.validUntil()
                            )
                    ));
        }
    }
}
