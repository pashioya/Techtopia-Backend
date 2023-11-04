package be.keg.prog6.parkOperations.core;

import be.keg.prog6.parkOperations.domain.QueGate;
import be.keg.prog6.parkOperations.domain.TicketInQue;
import be.keg.prog6.parkOperations.ports.in.LoadQueGateCommand;
import be.keg.prog6.parkOperations.ports.in.LoadQueGateUseCase;
import be.keg.prog6.parkOperations.ports.out.LoadQueGatePort;
import be.keg.prog6.parkOperations.ports.out.LoadTicketInQuePort;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class DefaultLoadQueGateUseCase implements LoadQueGateUseCase {

    private final LoadQueGatePort loadQueGatePort;
    private final LoadTicketInQuePort loadTicketInQuePort;
    private final Logger logger = LoggerFactory.getLogger(DefaultLoadQueGateUseCase.class);

    @Override
    public Optional<QueGate> loadQueGate(LoadQueGateCommand loadQueGateCommand) {
        Optional<QueGate> queGateOptional = loadQueGatePort.loadQueGate(loadQueGateCommand.queGateUUID());

        List<TicketInQue> ticketsInQueue = loadTicketInQuePort.loadTicketsInQueFromTodayByQueUUID(loadQueGateCommand.queGateUUID());

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

}