package be.kdg.prog6.ticketing.adapters.in.web;

import be.kdg.prog6.ticketing.domain.Ticket;
import be.kdg.prog6.ticketing.ports.in.CreateTicketCommand;
import be.kdg.prog6.ticketing.ports.in.CreateTicketUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class TicketController {
    private final CreateTicketUseCase createTicketUseCase;

    @PostMapping("/visitor/{visitorUUID}/ticket")
    public void createTicket(@PathVariable String visitorUUID, @RequestBody CreateTicketDTO createTicketDTO) {
        createTicketUseCase.createTicket(
                new CreateTicketCommand(
                        new Ticket(
                                createTicketDTO.getTicketDurationType(),
                                createTicketDTO.getTicketAgeType(),
                                createTicketDTO.getValidFrom(),
                                createTicketDTO.getValidUntil(),
                                new Ticket.TicketUUID(
                                        UUID.randomUUID()
                                ),
                                new Ticket.VisitorUUID(UUID.fromString(visitorUUID))
                        )
                )
        );
    }

}