package be.kdg.prog6.entranceGate.core;

import be.kdg.prog6.entranceGate.domain.ScannedTicket;
import be.kdg.prog6.entranceGate.ports.in.RequestTicketValidityCommand;
import be.kdg.prog6.entranceGate.ports.in.TicketValidityCheck;
import be.kdg.prog6.entranceGate.ports.out.ScannedTicketLoadPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class DefaultTicketValidityCheck implements TicketValidityCheck {

    private final ScannedTicketLoadPort scannedTicketLoadPort;
    @Override
    public boolean isValid(RequestTicketValidityCommand requestTicketValidityCommand) {
        Optional<ScannedTicket> scannedTicket = scannedTicketLoadPort.loadScannedTicket(requestTicketValidityCommand.ticketUUID());
        return scannedTicket.map(ScannedTicket::isValid).orElse(false);
    }
}
