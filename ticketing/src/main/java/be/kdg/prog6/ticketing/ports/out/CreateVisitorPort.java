package be.kdg.prog6.ticketing.ports.out;

import be.kdg.prog6.ticketing.domain.Visitor;

public interface CreateVisitorPort {
    void createVisitor(Visitor visitor);
}
