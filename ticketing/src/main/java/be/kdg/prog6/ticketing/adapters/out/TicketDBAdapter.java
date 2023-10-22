package be.kdg.prog6.ticketing.adapters.out;

import be.kdg.prog6.ticketing.domain.Ticket;
import be.kdg.prog6.ticketing.domain.Visitor;
import be.kdg.prog6.ticketing.ports.out.TicketCreatePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TicketDBAdapter implements TicketCreatePort {

    private final TicketRepository ticketRepository;


    @Override
    public void createTicket(Visitor.VisitorUUID visitorUUID, Ticket ticket) {
        TicketJpaEntity ticketJpaEntity = new TicketJpaEntity();

        ticketJpaEntity.setTicketUUID(String.valueOf(ticket.getTicketUUID()));
        ticketJpaEntity.setVisitorUUID(visitorUUID.uuid());
        ticketJpaEntity.setTicketDurationType(ticket.getTicketDurationType());
        ticketJpaEntity.setTicketAgeType(ticket.getTicketAgeType());
        ticketJpaEntity.setValidFrom(ticket.getValidFrom());
        ticketJpaEntity.setValidUntil(ticket.getValidUntil());

        ticketRepository.save(ticketJpaEntity);
    }
}
