package be.keg.prog6.parkOperations.config;

import be.keg.prog6.parkOperations.adapters.out.db.*;
import be.keg.prog6.parkOperations.domain.RefreshmentStandStatus;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.awt.Point;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class DatabaseSeeder implements ApplicationRunner {

    private final AttractionRepository attractionRepository;
    private final QueGateRepository queGateRepository;
    private final RefreshmentStandRepository refreshmentStandRepository;

    public void seed() {
        List<AttractionJPAEntity> attractions = new ArrayList<>();

        List<UUID> queGateUUIDs = new ArrayList<>();
        List<UUID> attractionUUIDs = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            queGateUUIDs.add(UUID.randomUUID());
            attractionUUIDs.add(UUID.randomUUID());

            QueGateJPAEntity queGate = new QueGateJPAEntity(
                    queGateUUIDs.get(i),
                    32,
                    0,
                    Duration.ZERO,
                    attractionUUIDs.get(i)
            );

            queGateRepository.save(queGate);
        }

        List<RefreshmentStandJPAEntity> refreshmentStands = new ArrayList<>();

        refreshmentStands.add(new RefreshmentStandJPAEntity(
                UUID.randomUUID(),
                "Test Refreshment Stand",
                "Test Refreshment Stand Description",
                new Point(6, 9),
                RefreshmentStandStatus.OPEN
        ));

        refreshmentStands.add(new RefreshmentStandJPAEntity(
                UUID.randomUUID(),
                "Test Refreshment Stand 2",
                "Test Refreshment Stand Description 2",
                new Point(1, 3),
                RefreshmentStandStatus.OPEN
        ));

        refreshmentStands.add(new RefreshmentStandJPAEntity(
                UUID.randomUUID(),
                "Test Refreshment Stand 3",
                "Test Refreshment Stand Description 3",
                new Point(4, 7),
                RefreshmentStandStatus.OPEN
        ));

        refreshmentStands.add(new RefreshmentStandJPAEntity(
                UUID.randomUUID(),
                "Test Refreshment Stand 4",
                "Test Refreshment Stand Description 4",
                new Point(2, 4),
                RefreshmentStandStatus.OPEN
        ));




        attractions.add(new AttractionJPAEntity(
                attractionUUIDs.get(0),
                "Test Attraction",
                "Test Attraction Description",
                new Point(6, 9),
                queGateUUIDs.get(0)
        ));

        attractions.add(new AttractionJPAEntity(
                attractionUUIDs.get(1),
                "Test Attraction 2",
                "Test Attraction Description 2",
                new Point(1, 3),
                queGateUUIDs.get(1)
        ));

        attractions.add(new AttractionJPAEntity(
                attractionUUIDs.get(2),
                "Test Attraction 3",
                "Test Attraction Description 3",
                new Point(4, 7),
                queGateUUIDs.get(2)
        ));

        attractions.add(new AttractionJPAEntity(
                attractionUUIDs.get(3),
                "Test Attraction 4",
                "Test Attraction Description 4",
                new Point(2, 4),
                queGateUUIDs.get(3)
        ));

        refreshmentStandRepository.saveAll(refreshmentStands);
        attractionRepository.saveAll(attractions);
    }

    @Override
    public void run(ApplicationArguments args) {
        seed();
    }
}
