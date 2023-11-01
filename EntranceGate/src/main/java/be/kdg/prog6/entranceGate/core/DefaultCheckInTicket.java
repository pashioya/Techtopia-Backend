package be.kdg.prog6.entranceGate.core;

import be.kdg.prog6.entranceGate.domain.ScannedTicket;
import be.kdg.prog6.common.facades.TicketAction;
import be.kdg.prog6.entranceGate.domain.TicketActivity;
import be.kdg.prog6.entranceGate.ports.in.CheckInTicketCommand;
import be.kdg.prog6.entranceGate.ports.in.CheckInTicketUseCase;
import be.kdg.prog6.entranceGate.ports.out.ScannedTicketActivityCreatePort;
import be.kdg.prog6.entranceGate.ports.out.ScannedTicketLoadPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class DefaultCheckInTicket implements CheckInTicketUseCase {

    private final ScannedTicketLoadPort scannedTicketLoadPort;

    private final List<ScannedTicketActivityCreatePort> scannedTicketActivityCreatePorts;


    @Override
    public void checkInTicket(CheckInTicketCommand checkInTicketCommand) {
//        check if the ticket is valid.
//        if not valid, throw an exception
//        Check previous ticket activities to see if the ticket is already checked in
//        if checked in, throw an exception
//        if not checked in, create a new ticket activity and save it
        Optional<ScannedTicket> scannedTicket = scannedTicketLoadPort
                .loadScannedTicket(checkInTicketCommand.ticket());

        if (scannedTicket.isEmpty()) {
            throw new RuntimeException("Ticket not found");
        }

        if (scannedTicket.get().isValid()) {
            throw new RuntimeException("Ticket is not valid");
        }

        if (scannedTicket.get()
                .getActivityWindow()
                .getLatestActivity()
                .action() == TicketAction.CHECK_IN) {
            throw new RuntimeException("Ticket is already checked in");
        }

        TicketActivity newTicketActivity = new TicketActivity(
                UUID.randomUUID(),
                TicketAction.CHECK_IN,
                checkInTicketCommand.entranceGate(),
                LocalDateTime.now()
        );
        scannedTicket.get().getActivityWindow().add(
                newTicketActivity
        );

        scannedTicketActivityCreatePorts.forEach(p ->
                p.createScannedTicketActivity(
                        scannedTicket.get().getTicketUUID(),
                        newTicketActivity
                )
        );
    }
}
