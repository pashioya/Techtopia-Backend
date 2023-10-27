package be.kdg.prog6.entranceGate.adapters.in.web;

import be.kdg.prog6.entranceGate.ports.in.RequestTicketValidityCommand;
import be.kdg.prog6.entranceGate.ports.in.TicketValidityCheck;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class TicketController {
    private final TicketValidityCheck ticketValidityCheck;


    @PostMapping("/ticket/{uuid}")
    public boolean isTicketValid(@PathVariable UUID uuid) {
        return ticketValidityCheck.isValid(new RequestTicketValidityCommand(uuid));
    }
}
