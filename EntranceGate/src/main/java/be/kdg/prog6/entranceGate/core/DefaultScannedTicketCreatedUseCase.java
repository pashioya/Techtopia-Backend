package be.kdg.prog6.entranceGate.core;

import be.kdg.prog6.common.facades.ticket.TicketCreatedEvent;
import be.kdg.prog6.entranceGate.domain.ScannedTicket;
import be.kdg.prog6.entranceGate.ports.in.ScannedTicketCreatedUseCase;
import be.kdg.prog6.entranceGate.ports.out.ScannedTicketCreatePort;
import be.kdg.prog6.entranceGate.ports.out.ScannedTicketCreatedProjector;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DefaultScannedTicketCreatedUseCase implements ScannedTicketCreatedUseCase{

    private final ScannedTicketCreatedProjector scannedTicketCreatedProjector;
    private final ScannedTicketCreatePort scannedTicketCreatePort;

        @Override
        public void createTicket(TicketCreatedEvent event) {
            Optional<ScannedTicket> scannedTicket =  scannedTicketCreatedProjector.project(event);
            scannedTicket.ifPresent(scannedTicketCreatePort::createScannedTicket);
        }



}
