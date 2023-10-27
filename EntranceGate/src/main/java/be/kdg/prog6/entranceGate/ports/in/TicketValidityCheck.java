package be.kdg.prog6.entranceGate.ports.in;

public interface TicketValidityCheck {

    boolean isValid(RequestTicketValidityCommand requestTicketValidityCommand);

}
