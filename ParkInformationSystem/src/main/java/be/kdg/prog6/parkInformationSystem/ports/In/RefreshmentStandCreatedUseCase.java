package be.kdg.prog6.parkInformationSystem.ports.In;

import be.kdg.prog6.common.facades.refreshmentStand.RefreshmentStandCreatedEvent;

public interface RefreshmentStandCreatedUseCase {
    void createRefreshmentStand(RefreshmentStandCreatedEvent refreshmentStandCreatedEvent);
}
