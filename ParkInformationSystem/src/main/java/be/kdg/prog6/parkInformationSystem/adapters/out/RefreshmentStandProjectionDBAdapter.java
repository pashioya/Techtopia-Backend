package be.kdg.prog6.parkInformationSystem.adapters.out;

import be.kdg.prog6.parkInformationSystem.domain.RefreshmentStand;
import be.kdg.prog6.parkInformationSystem.ports.out.CreateRefreshmentStandPort;
import be.kdg.prog6.parkInformationSystem.ports.out.LoadRefreshmentStandPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class RefreshmentStandProjectionDBAdapter implements CreateRefreshmentStandPort, LoadRefreshmentStandPort {
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

    @Override
    public List<RefreshmentStand> loadRefreshmentStands() {
        return refreshmentStandProjectionRepository.findAll()
                .stream()
                .map(refreshmentStandProjectionJpaEntity -> new RefreshmentStand(
                        new RefreshmentStand.RefreshmentStandUUID(refreshmentStandProjectionJpaEntity.getRefreshmentStandUUID()),
                        refreshmentStandProjectionJpaEntity.getName(),
                        refreshmentStandProjectionJpaEntity.getDescription(),
                        refreshmentStandProjectionJpaEntity.getLocation(),
                        refreshmentStandProjectionJpaEntity.getStatus()
                ))
                .toList();
    }
}
