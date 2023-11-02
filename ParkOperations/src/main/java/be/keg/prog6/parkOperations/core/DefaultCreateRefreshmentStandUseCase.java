package be.keg.prog6.parkOperations.core;

import be.keg.prog6.parkOperations.domain.RefreshmentStand;
import be.keg.prog6.parkOperations.domain.RefreshmentStandStatus;
import be.keg.prog6.parkOperations.ports.in.CreateRefreshmentStandCommand;
import be.keg.prog6.parkOperations.ports.in.CreateRefreshmentStandUseCase;
import be.keg.prog6.parkOperations.ports.out.CreateRefreshmentStandPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DefaultCreateRefreshmentStandUseCase implements CreateRefreshmentStandUseCase {

    private final List<CreateRefreshmentStandPort> createRefreshmentStandPort;

    @Override
    public void createRefreshmentStand(CreateRefreshmentStandCommand createRefreshmentStandCommand) {

        createRefreshmentStandPort.forEach(port -> port.createRefreshmentStand(
                new RefreshmentStand(
                        new RefreshmentStand.RefreshmentStandUUID(UUID.randomUUID()),
                        createRefreshmentStandCommand.name(),
                        createRefreshmentStandCommand.description(),
                        createRefreshmentStandCommand.location(),
                        RefreshmentStandStatus.OPEN

                )
        ));
    }
}
