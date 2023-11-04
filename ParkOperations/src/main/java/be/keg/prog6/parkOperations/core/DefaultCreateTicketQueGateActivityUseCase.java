package be.keg.prog6.parkOperations.core;

import be.kdg.prog6.common.facades.ticket.TicketAction;
import be.keg.prog6.parkOperations.domain.TicketInQue;
import be.keg.prog6.parkOperations.domain.TicketQueGateActivity;
import be.keg.prog6.parkOperations.ports.in.CreateTicketQueGateActivityCommand;
import be.keg.prog6.parkOperations.ports.in.CreateTicketQueGateActivityUseCase;
import be.keg.prog6.parkOperations.ports.out.CreateTicketInQuePort;
import be.keg.prog6.parkOperations.ports.out.CreateTicketQueGateActivityPort;
import be.keg.prog6.parkOperations.ports.out.UpdateTicketInQuePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor
public class DefaultCreateTicketQueGateActivityUseCase implements CreateTicketQueGateActivityUseCase {

    private final CreateTicketQueGateActivityPort createTicketQueGateActivityPort;
    private final CreateTicketInQuePort createTicketInQuePort;
    private final UpdateTicketInQuePort updateTicketInQuePort;
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

        if (createTicketQueGateActivityCommand.ticketAction().equals(TicketAction.CHECK_IN))
            createTicketInQuePort.createTicketInQue(new TicketInQue(
                    createTicketQueGateActivityCommand.ticketUUID(),
                    createTicketQueGateActivityCommand.queGateUUID()
            ));

        if (createTicketQueGateActivityCommand.ticketAction().equals(TicketAction.CHECK_OUT))
            updateTicketInQuePort.updateTicketInQue(new TicketInQue(
                    createTicketQueGateActivityCommand.ticketUUID(),
                    createTicketQueGateActivityCommand.queGateUUID()
            ));
    }
}
