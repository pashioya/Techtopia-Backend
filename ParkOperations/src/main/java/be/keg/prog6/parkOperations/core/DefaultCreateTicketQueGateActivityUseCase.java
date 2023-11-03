package be.keg.prog6.parkOperations.core;

import be.keg.prog6.parkOperations.domain.TicketQueGateActivity;
import be.keg.prog6.parkOperations.ports.in.CreateTicketQueGateActivityCommand;
import be.keg.prog6.parkOperations.ports.in.CreateTicketQueGateActivityUseCase;
import be.keg.prog6.parkOperations.ports.out.CreateTicketQueGateActivityPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor
public class DefaultCreateTicketQueGateActivityUseCase implements CreateTicketQueGateActivityUseCase {

    private final CreateTicketQueGateActivityPort createTicketQueGateActivityPort;
    @Override
    public void createTicketQueGateActivity(CreateTicketQueGateActivityCommand createTicketQueGateActivityCommand) {
        createTicketQueGateActivityPort.createTicketQueGateActivity(
                new TicketQueGateActivity(
                        createTicketQueGateActivityCommand.ticketUUID(),
                        createTicketQueGateActivityCommand.queGateUUID(),
                        createTicketQueGateActivityCommand.ticketAction(),
                        Instant.now()
                )
        );
    }
}
