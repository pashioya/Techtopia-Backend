package be.keg.prog6.parkOperations.core;

import be.kdg.prog6.common.facades.ticket.TicketAction;
import be.keg.prog6.parkOperations.domain.QueGate;
import be.keg.prog6.parkOperations.domain.TicketInQue;
import be.keg.prog6.parkOperations.domain.TicketQueGateActivity;
import be.keg.prog6.parkOperations.ports.in.CreateTicketQueGateActivityCommand;
import be.keg.prog6.parkOperations.ports.in.CreateTicketQueGateActivityUseCase;
import be.keg.prog6.parkOperations.ports.out.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DefaultCreateTicketQueGateActivityUseCase implements CreateTicketQueGateActivityUseCase {

    private final CreateTicketQueGateActivityPort createTicketQueGateActivityPort;
    private final CreateTicketInQuePort createTicketInQuePort;
    private final UpdateTicketInQuePort updateTicketInQuePort;
    private final LoadQueGatePort loadQueGatePort;
    private final UpdateQueGatePort updateQueGatePort;
    private final LoadTicketInQuePort loadTicketInQuePort;
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

        Optional<QueGate> queGateOptional = loadQueGatePort.loadQueGate(createTicketQueGateActivityCommand.queGateUUID());

        if (createTicketQueGateActivityCommand.ticketAction().equals(TicketAction.CHECK_IN)) {
            createTicketInQuePort.createTicketInQue(new TicketInQue(
                    createTicketQueGateActivityCommand.ticketUUID(),
                    createTicketQueGateActivityCommand.queGateUUID()
            ));
            queGateOptional.ifPresent(
                    qG -> {
                        qG.setCurrentCapacity(qG.getCurrentCapacity()+1);
                        qG.setAverageWaitTime(calcAverageWaitTime(createTicketQueGateActivityCommand.queGateUUID()));
                    }
            );
        }

        if (createTicketQueGateActivityCommand.ticketAction().equals(TicketAction.CHECK_OUT)) {
            updateTicketInQuePort.updateTicketInQue(new TicketInQue(
                    createTicketQueGateActivityCommand.ticketUUID(),
                    createTicketQueGateActivityCommand.queGateUUID()
            ));
            queGateOptional.ifPresent(
                    qG -> {
                        qG.setCurrentCapacity(qG.getCurrentCapacity()+1);
                        qG.setAverageWaitTime(calcAverageWaitTime(createTicketQueGateActivityCommand.queGateUUID()));
                    }
            );
        }

        queGateOptional.ifPresent(updateQueGatePort::updateQueGate);
    }

    private Duration calcAverageWaitTime(UUID queUUID){
        List<TicketInQue> checkedOutTicketsInQueue = loadTicketInQuePort.loadCheckedOutTicketsInQueFromTodayByQueUUID(queUUID);

        return checkedOutTicketsInQueue.stream()
                .map(ticket -> Duration.between(ticket.getEntryTime(), ticket.getExitTime()))
                .reduce(Duration.ZERO, Duration::plus)
                .dividedBy(checkedOutTicketsInQueue.size());
    }
}
