package be.kdg.prog6.parkInformationSystem.adapters.out;

import be.kdg.prog6.parkInformationSystem.domain.RefreshmentStand;
import be.kdg.prog6.parkInformationSystem.ports.out.CreateRefreshmentStandPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class RefreshmentStandProjectionDBAdapter implements CreateRefreshmentStandPort {
    private final RefreshmentStandProjectionRepository refreshmentStandProjectionRepository;

    @Override
    public void createRefreshmentStand(RefreshmentStand refreshmentStand) {
        RefreshmentStandProjectionJpaEntity refreshmentStandProjectionJpaEntity = new RefreshmentStandProjectionJpaEntity();
        refreshmentStandProjectionJpaEntity.setRefreshmentStandUUID(refreshmentStand.getRefreshmentStandUUID().uuid());
        refreshmentStandProjectionJpaEntity.setName(refreshmentStand.getName());
        refreshmentStandProjectionJpaEntity.setDescription(refreshmentStand.getDescription());
        refreshmentStandProjectionJpaEntity.setLocation(refreshmentStand.getLocation());
        refreshmentStandProjectionJpaEntity.setStatus(refreshmentStand.getStatus());

        refreshmentStandProjectionRepository.save(refreshmentStandProjectionJpaEntity);
    }
}
