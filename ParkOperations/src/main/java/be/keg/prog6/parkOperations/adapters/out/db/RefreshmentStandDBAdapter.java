package be.keg.prog6.parkOperations.adapters.out.db;


import be.keg.prog6.parkOperations.domain.RefreshmentStand;
import be.keg.prog6.parkOperations.ports.out.CreateRefreshmentStandPort;
import be.keg.prog6.parkOperations.ports.out.DeleteRefreshmentStandPort;
import be.keg.prog6.parkOperations.ports.out.LoadRefreshmentStandPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class RefreshmentStandDBAdapter implements CreateRefreshmentStandPort, DeleteRefreshmentStandPort, LoadRefreshmentStandPort {

    private final RefreshmentStandRepository refreshmentStandRepository;
    @Override
    public void createRefreshmentStand(RefreshmentStand refreshmentStand) {
        refreshmentStandRepository.save(
                new RefreshmentStandJPAEntity(
                        refreshmentStand.getRefreshmentStandUUID().uuid(),
                        refreshmentStand.getName(),
                        refreshmentStand.getDescription(),
                        refreshmentStand.getLocation(),
                        refreshmentStand.getRefreshmentStandStatus()
                )
        );
    }

    @Override
    public void deleteRefreshmentStand(RefreshmentStand refreshmentStand) {
        refreshmentStandRepository.delete(
                new RefreshmentStandJPAEntity(
                        refreshmentStand.getRefreshmentStandUUID().uuid(),
                        refreshmentStand.getName(),
                        refreshmentStand.getDescription(),
                        refreshmentStand.getLocation(),
                        refreshmentStand.getRefreshmentStandStatus()
                )
        );
    }

    @Override
    public Optional<RefreshmentStand> loadRefreshmentStand(UUID uuid) {
        return refreshmentStandRepository.findById(uuid).map(refreshmentStandJPAEntity -> new RefreshmentStand(
                new RefreshmentStand.RefreshmentStandUUID(refreshmentStandJPAEntity.getUuid()),
                refreshmentStandJPAEntity.getName(),
                refreshmentStandJPAEntity.getDescription(),
                refreshmentStandJPAEntity.getLocation(),
                refreshmentStandJPAEntity.getRefreshmentStandStatus()
        ));
    }
}
