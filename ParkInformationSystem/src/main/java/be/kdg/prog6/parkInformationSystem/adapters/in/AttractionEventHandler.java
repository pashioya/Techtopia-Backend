package be.kdg.prog6.parkInformationSystem.adapters.in;

import be.kdg.prog6.common.events.EventCatalog;
import be.kdg.prog6.common.events.EventMessage;
import be.kdg.prog6.common.facades.attraction.AttractionEvent;

public interface AttractionEventHandler<T extends AttractionEvent>{

    boolean appliesTo(EventCatalog eventCatalog);

    default AttractionEventHandler<T> receive(EventMessage eventMessage) {
        return this;
    }

    AttractionEvent map(String eventBody);

    void handle(AttractionEvent attractionEventBody);
}
