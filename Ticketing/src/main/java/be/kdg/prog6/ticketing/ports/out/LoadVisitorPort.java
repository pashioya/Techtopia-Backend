package be.kdg.prog6.ticketing.ports.out;

import be.kdg.prog6.ticketing.domain.Visitor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LoadVisitorPort {

    Optional<Visitor> loadVisitor(UUID visitorUUID);

    List<Visitor> loadAllVisitors();
}
