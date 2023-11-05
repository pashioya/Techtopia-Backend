package be.kdg.prog6.parkInformationSystem.ports.out;

import be.kdg.prog6.parkInformationSystem.domain.RefreshmentStand;

import java.util.List;

public interface LoadRefreshmentStandPort {

    List<RefreshmentStand> loadRefreshmentStands();
}
