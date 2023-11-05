package be.kdg.prog6.parkInformationSystem.core;

import be.kdg.prog6.parkInformationSystem.domain.RefreshmentStand;
import be.kdg.prog6.parkInformationSystem.ports.In.LoadRefreshmentStandUseCase;
import be.kdg.prog6.parkInformationSystem.ports.out.LoadRefreshmentStandPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DefaultLoadRefreshmentStandUseCase implements LoadRefreshmentStandUseCase {

    private final LoadRefreshmentStandPort loadRefreshmentStandPort;


    @Override
    public List<RefreshmentStand> loadRefreshmentStands() {
        return loadRefreshmentStandPort.loadRefreshmentStands();
    }
}
