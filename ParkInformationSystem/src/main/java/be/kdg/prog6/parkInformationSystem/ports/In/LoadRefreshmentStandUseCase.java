package be.kdg.prog6.parkInformationSystem.ports.In;

import be.kdg.prog6.parkInformationSystem.domain.RefreshmentStand;

import java.util.List;

public interface LoadRefreshmentStandUseCase {

    List<RefreshmentStand> loadRefreshmentStands();
}
