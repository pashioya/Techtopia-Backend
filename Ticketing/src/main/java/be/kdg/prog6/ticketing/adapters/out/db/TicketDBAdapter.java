package be.kdg.prog6.ticketing.adapters.out.db;

import be.kdg.prog6.ticketing.domain.Ticket;
import be.kdg.prog6.ticketing.ports.out.CreateTicketPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TicketDBAdapter implements CreateTicketPort {

    private final TicketRepository ticketRepository;


    public void ticketCreated(Ticket ticket) {
        TicketJpaEntity ticketJpaEntity = new TicketJpaEntity();

        ticketJpaEntity.setUuid(ticket.getTicketUUID().uuid());
        ticketJpaEntity.setVisitor(ticket.getVisitorUUID().uuid());
        ticketJpaEntity.setTicketDurationType(ticket.getTicketDurationType());
        ticketJpaEntity.setTicketAgeType(ticket.getTicketAgeType());
        ticketJpaEntity.setValidFrom(ticket.getValidFrom());

        ticketRepository.save(ticketJpaEntity);
    }
}
