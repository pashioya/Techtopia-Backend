package be.kdg.prog6.ticketing.core;

import be.kdg.prog6.ticketing.ports.in.CreateTicketUseCase;
import be.kdg.prog6.ticketing.ports.in.CreateTicketCommand;
import be.kdg.prog6.ticketing.ports.out.TicketCreatePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DefaultCreateTicketUseCase implements CreateTicketUseCase{

    private final TicketCreatePort ticketCreatePort;

    @Override
    public void createTicket(CreateTicketCommand createTicketCommand) {
        ticketCreatePort.createTicket(
                createTicketCommand.ticket()
        );
    }
}
