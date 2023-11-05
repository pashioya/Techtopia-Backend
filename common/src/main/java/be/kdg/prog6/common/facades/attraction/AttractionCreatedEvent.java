package be.kdg.prog6.common.facades.attraction;

import java.util.UUID;

public record AttractionCreatedEvent(
        UUID attractionUUID,
        UUID queGateUUID,
        String name,
        String description
) implements AttractionEvent{
}
