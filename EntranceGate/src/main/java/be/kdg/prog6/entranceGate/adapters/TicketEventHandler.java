package be.kdg.prog6.entranceGate.adapters;

import be.kdg.prog6.common.events.Event;
import be.kdg.prog6.common.events.EventCatalog;
import be.kdg.prog6.common.events.EventMessage;

public interface TicketEventHandler<T extends Event> {

    boolean appliesTo(EventCatalog eventCatalog);

    default TicketEventHandler<T> receive(EventMessage eventMessage) {
        return this;
    }

    Event map(String eventBody);

    void handle(Event  ticketEventBody);
}
