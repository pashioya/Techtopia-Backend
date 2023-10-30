package be.kdg.prog6.entranceGate.core;


import be.kdg.prog6.entranceGate.domain.ScannedTicket;
import be.kdg.prog6.common.facades.TicketAction;
import be.kdg.prog6.entranceGate.domain.TicketActivity;
import be.kdg.prog6.entranceGate.ports.in.CheckOutTicketCommand;
import be.kdg.prog6.entranceGate.ports.in.CheckOutTicketUseCase;
import be.kdg.prog6.entranceGate.ports.out.ScannedTicketActivityCreatePort;
import be.kdg.prog6.entranceGate.ports.out.ScannedTicketProjectionPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class DefaultCheckOutTicket implements CheckOutTicketUseCase {

    private final ScannedTicketProjectionPort scannedTicketProjectionPort;

    private final List<ScannedTicketActivityCreatePort> scannedTicketActivityCreatePorts;


    @Override
    public void checkOutTicket(CheckOutTicketCommand checkOutTicketCommand) {
//        check if the ticket is valid.
//        if not valid, throw an exception
//        Check previous ticket activities to see if the ticket is already checked in
//        if checked in, throw an exception
//        if not checked in, create a new ticket activity and save it
        Optional<ScannedTicket> scannedTicket = scannedTicketProjectionPort
                .loadScannedTicket(checkOutTicketCommand.ticket());

        if (scannedTicket.isEmpty()) {
            throw new RuntimeException("Ticket not found");
        }

        if (scannedTicket.get().isValid()) {
            throw new RuntimeException("Ticket is not valid");
        }

        if (scannedTicket.get()
                .getActivityWindow()
                .getLatestActivity()
                .action() == TicketAction.CHECK_OUT) {
            throw new RuntimeException("Ticket is already checked out");
        }

        TicketActivity newTicketActivity = new TicketActivity(
                UUID.randomUUID(),
                TicketAction.CHECK_OUT,
                checkOutTicketCommand.entranceGate(),
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
