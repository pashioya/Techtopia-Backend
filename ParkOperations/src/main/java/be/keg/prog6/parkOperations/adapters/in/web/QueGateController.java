package be.keg.prog6.parkOperations.adapters.in.web;

import be.keg.prog6.parkOperations.adapters.in.web.dto.QueGateDTO;
import be.keg.prog6.parkOperations.ports.in.CreateTicketQueGateActivityCommand;
import be.keg.prog6.parkOperations.ports.in.CreateTicketQueGateActivityUseCase;
import be.keg.prog6.parkOperations.ports.in.LoadQueGateCommand;
import be.keg.prog6.parkOperations.ports.in.LoadQueGateUseCase;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@AllArgsConstructor
public class QueGateController {

    private final CreateTicketQueGateActivityUseCase createTicketQueGateActivityUseCase;

    private final LoadQueGateUseCase loadQueGateUseCase;

    private final Logger logger = LoggerFactory.getLogger(QueGateController.class);

    @PostMapping("/queGate/checkIn")
    public void checkInTicket(@RequestBody CreateTicketQueGateActivityCommand createTicketQueGateActivityCommand) {
        createTicketQueGateActivityUseCase.createTicketQueGateActivity(createTicketQueGateActivityCommand);
    }

    @PostMapping("/queGate/checkOut")
    public void checkOutTicket(@RequestBody CreateTicketQueGateActivityCommand createTicketQueGateActivityCommand) {
        createTicketQueGateActivityUseCase.createTicketQueGateActivity(createTicketQueGateActivityCommand);
    }

    @GetMapping("/queGate/{uuid}")
    public QueGateDTO getQueGate(@PathVariable UUID uuid) {
        logger.info("Loading que gate: " + uuid);

//        TODO: FIX THIS, [org.springframework.web.HttpMediaTypeNotAcceptableException: No acceptable representation]
        return loadQueGateUseCase
                .loadQueGate(new LoadQueGateCommand(uuid))
                .map(queGate -> new QueGateDTO(
                        queGate.getMaxCapacity(),
                        queGate.getCurrentCapacity(),
                        queGate.getAverageWaitTime(),
                        queGate.getAttractionUUID().uuid().toString()
                ))
                .orElse(null);
    }

}
