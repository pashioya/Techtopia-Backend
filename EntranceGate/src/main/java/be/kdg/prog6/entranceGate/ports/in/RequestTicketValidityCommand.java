package be.kdg.prog6.entranceGate.ports.in;

import java.util.UUID;

public record RequestTicketValidityCommand(UUID ticketUUID) {
}
