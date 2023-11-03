package be.keg.prog6.parkOperations.ports.out;

import be.keg.prog6.parkOperations.domain.QueGate;

import java.util.Optional;
import java.util.UUID;

public interface LoadQueGatePort {
        Optional<QueGate> loadQueGate(UUID uuid);
}
