package be.kdg.prog6.entranceGate.adapters;

import be.kdg.prog6.common.facades.TicketEvent;
import be.kdg.prog6.common.events.EventCatalog;
import be.kdg.prog6.common.events.EventMessage;

public interface TicketEventHandler<T extends TicketEvent> {

    boolean appliesTo(EventCatalog eventCatalog);

    default TicketEventHandler<T> receive(EventMessage eventMessage) {
        return this;
    }

    TicketEvent map(String eventBody);

    void handle(TicketEvent ticketTicketEventBody);
}
