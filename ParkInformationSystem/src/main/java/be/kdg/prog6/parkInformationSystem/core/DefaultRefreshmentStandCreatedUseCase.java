package be.kdg.prog6.parkInformationSystem.core;

import be.kdg.prog6.common.facades.refreshmentStand.RefreshmentStandCreatedEvent;
import be.kdg.prog6.parkInformationSystem.domain.RefreshmentStand;
import be.kdg.prog6.parkInformationSystem.domain.RefreshmentStandStatus;
import be.kdg.prog6.parkInformationSystem.ports.In.RefreshmentStandCreatedUseCase;
import be.kdg.prog6.parkInformationSystem.ports.out.CreateRefreshmentStandPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DefaultRefreshmentStandCreatedUseCase implements RefreshmentStandCreatedUseCase {

    private final CreateRefreshmentStandPort createRefreshmentStandPort;

    @Override
    public void createRefreshmentStand(RefreshmentStandCreatedEvent refreshmentStandCreatedEvent) {
        createRefreshmentStandPort.createRefreshmentStand(new RefreshmentStand(
                new RefreshmentStand.RefreshmentStandUUID(refreshmentStandCreatedEvent.refreshmentStand()),
                refreshmentStandCreatedEvent.name(),
                refreshmentStandCreatedEvent.description(),
                refreshmentStandCreatedEvent.location(),
                RefreshmentStandStatus.OPEN
        ));
    }
}
