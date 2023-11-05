package be.kdg.prog6.entranceGate.adapters.in.web;

import be.kdg.prog6.entranceGate.ports.in.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class EntranceGateController {
    private final TicketValidityCheck ticketValidityCheck;
    private final CheckInTicketUseCase checkInTicketUseCase;
    private final CheckOutTicketUseCase checkOutTicketUseCase;


    @GetMapping("/ticket/{uuid}")
    public boolean isTicketValid(@PathVariable UUID uuid) {
        return ticketValidityCheck.isValid(
                new RequestTicketValidityCommand(uuid)
        );
    }

    @PatchMapping("/gate/{gateUUID}/ticket/{ticketUUID}/checkIn")
    public void checkInTicket(@PathVariable UUID gateUUID, @PathVariable UUID ticketUUID) {
        checkInTicketUseCase.checkInTicket(
                new CheckInTicketCommand(
                        ticketUUID,
                        gateUUID
                )
        );
    }

    @PatchMapping("/gate/{gateUUID}/ticket/{ticketUUID}/checkOut")
    public void checkOutTicket(@PathVariable UUID gateUUID, @PathVariable UUID ticketUUID) {
        checkOutTicketUseCase.checkOutTicket(
                new CheckOutTicketCommand(
                        ticketUUID,
                        gateUUID
                )
        );
    }
}
