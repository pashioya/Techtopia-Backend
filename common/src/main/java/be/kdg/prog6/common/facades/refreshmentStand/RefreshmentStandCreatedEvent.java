package be.kdg.prog6.common.facades.refreshmentStand;

import java.awt.*;
import java.util.UUID;

public record RefreshmentStandCreatedEvent(
        UUID refreshmentStand,
        String name,
        String description,
        Point location
) implements RefreshmentStandEvent{
}
