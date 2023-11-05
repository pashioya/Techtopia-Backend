package be.kdg.prog6.common.facades.attraction;

import java.awt.*;
import java.time.Duration;
import java.util.UUID;

public record AttractionCreatedEvent(
        UUID attractionUUID,
        UUID queGateUUID,
        String name,
        String description,
        int maxCapacity,
        Duration averageWaitTime,
        Point location
) implements AttractionEvent{
}
