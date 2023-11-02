package be.keg.prog6.parkOperations.adapters.out.db;


import be.keg.prog6.parkOperations.domain.RefreshmentStand;
import be.keg.prog6.parkOperations.ports.out.CreateRefreshmentStandPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class RefreshmentStandDBAdapter implements CreateRefreshmentStandPort {

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
}
