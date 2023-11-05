package be.kdg.prog6.parkInformationSystem.adapters.in;

import be.kdg.prog6.common.events.EventCatalog;
import be.kdg.prog6.common.events.EventMessage;
import be.kdg.prog6.common.facades.refreshmentStand.RefreshmentStandEvent;

public interface RefreshmentStandEventHandler<T extends RefreshmentStandEvent> {

    boolean appliesTo(EventCatalog eventCatalog);

    default RefreshmentStandEventHandler<T> receive(EventMessage eventMessage) {
        return this;
    }

    RefreshmentStandEvent map(String eventBody);

    void handle(RefreshmentStandEvent refreshmentStandEventBody);
}
