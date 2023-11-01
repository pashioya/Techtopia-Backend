package be.kdg.prog6.entranceGate.core;

import be.kdg.prog6.common.facades.TicketCreatedTicketEvent;
import be.kdg.prog6.entranceGate.domain.ActivityWindow;
import be.kdg.prog6.entranceGate.domain.ScannedTicket;
import be.kdg.prog6.entranceGate.ports.out.ScannedTicketCreatedProjector;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultScannedTicketCreatedProjector implements ScannedTicketCreatedProjector {


    @Override
    public Optional<ScannedTicket> project(TicketCreatedTicketEvent ticketCreatedEvent) {
        return Optional.of(new ScannedTicket(
                new ScannedTicket.TicketUUID(ticketCreatedEvent.ticket()),
                new ScannedTicket.VisitorUUID(ticketCreatedEvent.visitor()),
                ticketCreatedEvent.validFrom(),
                ticketCreatedEvent.validUntil(),
                new ActivityWindow()
        ));
    }
}
