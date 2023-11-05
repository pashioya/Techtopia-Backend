package be.keg.prog6.parkOperations.adapters.in.web;

import be.keg.prog6.parkOperations.ports.in.CreateTicketQueGateActivityCommand;
import be.keg.prog6.parkOperations.ports.in.CreateTicketQueGateActivityUseCase;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class QueGateController {

    private final CreateTicketQueGateActivityUseCase createTicketQueGateActivityUseCase;

    private final Logger logger = LoggerFactory.getLogger(QueGateController.class);

    @PostMapping("/queGate/checkIn")
    public void checkInTicket(@RequestBody CreateTicketQueGateActivityCommand createTicketQueGateActivityCommand) {
        logger.info("Received checkInTicket request: {}", createTicketQueGateActivityCommand);
        createTicketQueGateActivityUseCase.createTicketQueGateActivity(createTicketQueGateActivityCommand);
    }

    @PostMapping("/queGate/checkOut")
    public void checkOutTicket(@RequestBody CreateTicketQueGateActivityCommand createTicketQueGateActivityCommand) {
        logger.info("Received checkOutTicket request: {}", createTicketQueGateActivityCommand);
        createTicketQueGateActivityUseCase.createTicketQueGateActivity(createTicketQueGateActivityCommand);
    }

}
