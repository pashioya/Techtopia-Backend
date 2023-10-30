package be.kdg.prog6.entranceGate.core;

import be.kdg.prog6.common.facades.TicketCreatedEvent;
import be.kdg.prog6.entranceGate.ports.in.ScannedTicketCreatedUseCase;
import be.kdg.prog6.entranceGate.ports.out.ScannedTicketCreatedProjector;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DefaultScannedTicketCreatedUseCase implements ScannedTicketCreatedUseCase{

    private final ScannedTicketCreatedProjector scannedTicketCreatedProjector;

        @Override
        public void createTicket(TicketCreatedEvent event) {
            scannedTicketCreatedProjector.project(event);
        }



}
