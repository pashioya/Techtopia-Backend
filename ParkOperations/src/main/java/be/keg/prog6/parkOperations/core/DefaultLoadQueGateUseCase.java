package be.keg.prog6.parkOperations.core;

import be.kdg.prog6.common.facades.ticket.TicketAction;
import be.keg.prog6.parkOperations.domain.QueGate;
import be.keg.prog6.parkOperations.domain.TicketQueGateActivity;
import be.keg.prog6.parkOperations.ports.in.LoadQueGateCommand;
import be.keg.prog6.parkOperations.ports.in.LoadQueGateUseCase;
import be.keg.prog6.parkOperations.ports.out.LoadQueGatePort;
import be.keg.prog6.parkOperations.ports.out.LoadTicketQueGateActivityPort;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class DefaultLoadQueGateUseCase implements LoadQueGateUseCase {

    private final LoadQueGatePort loadQueGatePort;
    private final LoadTicketQueGateActivityPort loadTicketQueGateActivityPort;
    private final Logger logger = LoggerFactory.getLogger(DefaultLoadQueGateUseCase.class);

    @Override
    public Optional<QueGate> loadQueGate(LoadQueGateCommand loadQueGateCommand) {
        Optional<QueGate> queGateOptional = loadQueGatePort.loadQueGate(loadQueGateCommand.queGateUUID());
        List<TicketQueGateActivity> ticketQueGateActivities = loadTicketQueGateActivityPort.loadTicketQueGateActivitiesForQueGate(loadQueGateCommand.queGateUUID());

        List<QueGate.TicketsInQue> ticketsInQueue = getTicketsInQues(ticketQueGateActivities);

        logger.info("Loaded que gate: " + queGateOptional.toString());

        return queGateOptional.map(
                queGate -> new QueGate(
                        queGate.getQueGateUUID(),
                        queGate.getMaxCapacity(),
                        queGate.getCurrentCapacity(),
                        queGate.getAverageWaitTime(),
                        queGate.getAttractionUUID(),
                        ticketsInQueue
                )
        );
    }

    private static List<QueGate.TicketsInQue> getTicketsInQues(List<TicketQueGateActivity> ticketQueGateActivities) {
        return ticketQueGateActivities.stream()
                .filter(activity -> activity.ticketAction() == TicketAction.CHECK_IN)
                .filter(activity -> ticketQueGateActivities.stream()
                        .noneMatch(checkOutActivity ->
                                checkOutActivity.ticketUUID().equals(activity.ticketUUID()) &&
                                        checkOutActivity.ticketAction() == TicketAction.CHECK_OUT
                        )
                )
                .map(activity -> new QueGate.TicketsInQue(activity.ticketUUID(), activity.time()))
                .collect(Collectors.toList());
    }



}