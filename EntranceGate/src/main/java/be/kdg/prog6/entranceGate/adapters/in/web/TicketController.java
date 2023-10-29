package be.kdg.prog6.entranceGate.adapters.in.web;

import be.kdg.prog6.entranceGate.ports.in.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class TicketController {
    private final TicketValidityCheck ticketValidityCheck;
    private final CheckInTicketUseCase checkInTicketUseCase;
    private final CheckOutTicketUseCase checkOutTicketUseCase;


    @PostMapping("/ticket/{uuid}")
    public boolean isTicketValid(@PathVariable UUID uuid) {
        return ticketValidityCheck.isValid(
                new RequestTicketValidityCommand(uuid)
        );
    }

    @PostMapping("/ticket/{uuid}/checkIn")
    public void checkInTicket(@PathVariable UUID uuid) {
        checkInTicketUseCase.checkInTicket(
                new CheckInTicketCommand(
                        uuid
                )
        );
    }

    @PostMapping("/ticket/{uuid}/checkOut")
    public void checkOutTicket(@PathVariable UUID uuid) {
        checkOutTicketUseCase.checkOutTicket(
                new CheckOutTicketCommand(
                        uuid
                )
        );
    }
}
