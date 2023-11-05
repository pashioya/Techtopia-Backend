package be.kdg.prog6.ticketing.config;

import be.kdg.prog6.ticketing.core.DefaultCreateTicketUseCase;
import be.kdg.prog6.ticketing.core.DefaultCreateVisitorUseCase;
import be.kdg.prog6.ticketing.domain.TicketAgeType;
import be.kdg.prog6.ticketing.domain.TicketDurationType;
import be.kdg.prog6.ticketing.domain.Visitor;
import be.kdg.prog6.ticketing.ports.in.CreateTicketCommand;
import be.kdg.prog6.ticketing.ports.in.CreateVisitorCommand;
import be.kdg.prog6.ticketing.ports.out.LoadVisitorPort;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Component
public class DataBaseSeeder implements ApplicationRunner {

    private final DefaultCreateVisitorUseCase defaultCreateVisitorUseCase;
    private final DefaultCreateTicketUseCase defaultCreateTicketUseCase;

    private final LoadVisitorPort loadVisitorPort;

    public void seed() {
        defaultCreateVisitorUseCase.createVisitor(
                new CreateVisitorCommand(
                        "John Smith",
                        "Boulevard Road 12",
                        "John.smith@gmail.com",
                        LocalDate.of(1998,12,23)
                )
        );

        defaultCreateVisitorUseCase.createVisitor(
                new CreateVisitorCommand(
                        "Jane Doe",
                        "Boulevard Road 12",
                        "Jane.Doe@gmail.com",
                        LocalDate.of(1998,12,23)
                )
        );

        defaultCreateVisitorUseCase.createVisitor(
                new CreateVisitorCommand(
                        "John Doe",
                        "Boulevard Road 12",
                        "df@gmail.com",
                        LocalDate.of(1998,12,23)
                )
        );

        List<Visitor> allVisitors = loadVisitorPort.loadAllVisitors();



        defaultCreateTicketUseCase.createTicket(
                new CreateTicketCommand(
                        allVisitors.get(0).getVisitorUUID().uuid(),
                        TicketDurationType.THREE_DAYS,
                        TicketAgeType.ADULT,
                        LocalDateTime.now(),
                        LocalDateTime.now().plusDays(3)
                )
        );

        defaultCreateTicketUseCase.createTicket(
                new CreateTicketCommand(
                        allVisitors.get(1).getVisitorUUID().uuid(),
                        TicketDurationType.DAY,
                        TicketAgeType.ADULT,
                        LocalDateTime.now().plusDays(1),
                        LocalDateTime.now().plusDays(2)
                )
        );

        defaultCreateTicketUseCase.createTicket(
                new CreateTicketCommand(
                        allVisitors.get(2).getVisitorUUID().uuid(),
                        TicketDurationType.DAY,
                        TicketAgeType.ADULT,
                        LocalDateTime.now().plusDays(4),
                        LocalDateTime.now().plusDays(5)
                )
        );
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        seed();
    }
}
