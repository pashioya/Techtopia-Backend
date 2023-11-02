package be.keg.prog6.parkOperations.ports.out;

import be.keg.prog6.parkOperations.domain.RefreshmentStand;

import java.util.Optional;
import java.util.UUID;

public interface LoadRefreshmentStandPort {
        Optional<RefreshmentStand> loadRefreshmentStand(UUID uuid);
}
