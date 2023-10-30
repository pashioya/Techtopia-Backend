package be.kdg.prog6.entranceGate.adapters.in.web;

import be.kdg.prog6.entranceGate.ports.in.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class EntranceGateController {
    private final TicketValidityCheck ticketValidityCheck;
    private final CheckInTicketUseCase checkInTicketUseCase;
    private final CheckOutTicketUseCase checkOutTicketUseCase;


    @PostMapping("/ticket/{uuid}")
    public boolean isTicketValid(@PathVariable UUID uuid) {
        return ticketValidityCheck.isValid(
                new RequestTicketValidityCommand(uuid)
        );
    }

    @PostMapping("/gate/{gateUUID}/ticket/{ticketUUID}/checkIn")
    public void checkInTicket(@PathVariable UUID gateUUID, @PathVariable UUID ticketUUID) {
        checkInTicketUseCase.checkInTicket(
                new CheckInTicketCommand(
                        ticketUUID,
                        gateUUID
                )
        );
    }

    @PostMapping("/gate/{gateUUID}/ticket/{ticketUUID}/checkOut")
    public void checkOutTicket(@PathVariable UUID gateUUID, @PathVariable UUID ticketUUID) {
        checkOutTicketUseCase.checkOutTicket(
                new CheckOutTicketCommand(
                        ticketUUID,
                        gateUUID
                )
        );
    }
}
