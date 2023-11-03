package be.keg.prog6.parkOperations.ports.in;

import be.keg.prog6.parkOperations.domain.QueGate;

import java.util.Optional;

public interface LoadQueGateUseCase {

    Optional<QueGate> loadQueGate(LoadQueGateCommand loadQueGateCommand);
}
