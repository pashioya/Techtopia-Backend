package be.keg.prog6.parkOperations.config;

import be.kdg.prog6.common.facades.ticket.TicketAction;
import be.keg.prog6.parkOperations.domain.QueGate;
import be.keg.prog6.parkOperations.ports.in.*;
import be.keg.prog6.parkOperations.ports.out.LoadQueGatePort;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
@AllArgsConstructor
public class DatabaseSeeder implements ApplicationRunner {

    private final CreateAttractionUseCase createAttractionUseCase;
    private final CreateRefreshmentStandUseCase createRefreshmentStandUseCase;
    private final CreateTicketQueGateActivityUseCase createTicketQueGateActivityUseCase;
    private final LoadQueGatePort loadQueGatePort;

    public void seed() {
        List<UUID> ticketUUIDs = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            ticketUUIDs.add(UUID.randomUUID());
        }

        Random random = new Random();


        for (int i = 0; i < 4; i++) {
            createRefreshmentStandUseCase.createRefreshmentStand(
                    new CreateRefreshmentStandCommand(
                            "Test Refreshment Stand 4",
                            "Test Refreshment Stand Description 4",
                            new Point(random.nextInt(100) + 1, random.nextInt(100) + 1)
                    )
            );
        }

        for (int i = 0; i < 4; i++) {
            createAttractionUseCase.createAttraction(
                    new CreateAttractionCommand(
                            "Test Attraction" + i,
                            "Test Attraction Description" + i,
                            new Point(6, 9),
                            35
                    )
            );
        }

        List<QueGate> allQueGates = loadQueGatePort.loadAllQueGates();

        for (int i = 0; i < 4; i++) {
            createTicketQueGateActivityUseCase.createTicketQueGateActivity(
                    new CreateTicketQueGateActivityCommand(
                            ticketUUIDs.get(i),
                            allQueGates.get(i).getQueGateUUID().uuid(),
                            TicketAction.CHECK_IN
                    )
            );
        }


        createTicketQueGateActivityUseCase.createTicketQueGateActivity(
                new CreateTicketQueGateActivityCommand(
                        ticketUUIDs.get(0),
                        allQueGates.get(0).getQueGateUUID().uuid(),
                        TicketAction.CHECK_IN
                )
        );

        createTicketQueGateActivityUseCase.createTicketQueGateActivity(
                new CreateTicketQueGateActivityCommand(
                        ticketUUIDs.get(0),
                        allQueGates.get(0).getQueGateUUID().uuid(),
                        TicketAction.CHECK_OUT
                )
        );

        createTicketQueGateActivityUseCase.createTicketQueGateActivity(
                new CreateTicketQueGateActivityCommand(
                        ticketUUIDs.get(1),
                        allQueGates.get(0).getQueGateUUID().uuid(),
                        TicketAction.CHECK_IN
                )
        );

        createTicketQueGateActivityUseCase.createTicketQueGateActivity(
                new CreateTicketQueGateActivityCommand(
                        ticketUUIDs.get(2),
                        allQueGates.get(1).getQueGateUUID().uuid(),
                        TicketAction.CHECK_IN
                )
        );

        createTicketQueGateActivityUseCase.createTicketQueGateActivity(
                new CreateTicketQueGateActivityCommand(
                        ticketUUIDs.get(3),
                        allQueGates.get(2).getQueGateUUID().uuid(),
                        TicketAction.CHECK_IN
                )
        );
        createTicketQueGateActivityUseCase.createTicketQueGateActivity(
                new CreateTicketQueGateActivityCommand(
                        ticketUUIDs.get(3),
                        allQueGates.get(2).getQueGateUUID().uuid(),
                        TicketAction.CHECK_OUT
                )
        );
    }

    @Override
    public void run(ApplicationArguments args) {
        seed();
    }
}
