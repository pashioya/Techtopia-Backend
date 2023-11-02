package be.keg.prog6.parkOperations.core;

import be.keg.prog6.parkOperations.ports.in.DeleteRefreshmentStandCommand;
import be.keg.prog6.parkOperations.ports.in.DeleteRefreshmentStandUseCase;
import be.keg.prog6.parkOperations.ports.out.DeleteRefreshmentStandPort;
import be.keg.prog6.parkOperations.ports.out.LoadRefreshmentStandPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DefaultDeleteRefreshmentStandUseCase implements DeleteRefreshmentStandUseCase {

    private final DeleteRefreshmentStandPort deleteRefreshmentStandPort;
    private final LoadRefreshmentStandPort loadRefreshmentStandPort;

    @Override
    public void deleteRefreshmentStand(DeleteRefreshmentStandCommand deleteRefreshmentStandCommand) {
        loadRefreshmentStandPort.loadRefreshmentStand(deleteRefreshmentStandCommand.uuid())
                .ifPresentOrElse(deleteRefreshmentStandPort::deleteRefreshmentStand, () -> {
                    throw new IllegalArgumentException("RefreshmentStand not found");
                });
    }
}
