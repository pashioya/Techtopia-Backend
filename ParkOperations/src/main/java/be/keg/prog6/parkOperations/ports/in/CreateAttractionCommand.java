package be.keg.prog6.parkOperations.ports.in;

import java.awt.*;

public record CreateAttractionCommand(
        String name,
        String description,
        Point location,
        int queGateMaxCapacity
) {
}
