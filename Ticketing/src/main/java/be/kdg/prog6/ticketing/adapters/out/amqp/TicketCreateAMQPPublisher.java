package be.kdg.prog6.ticketing.adapters.out.amqp;

import be.kdg.prog6.common.events.EventCatalog;
import be.kdg.prog6.common.events.EventHeader;
import be.kdg.prog6.common.events.EventMessage;
import be.kdg.prog6.ticketing.adapters.config.RabbitMQModuleTopology;
import be.kdg.prog6.ticketing.domain.Ticket;
import be.kdg.prog6.ticketing.events.TicketCreatedEvent;
import be.kdg.prog6.ticketing.ports.out.CreateTicketPort;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class TicketCreateAMQPPublisher implements CreateTicketPort {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public void ticketCreated(Ticket ticket) {
        var eventHeader = EventHeader.builder()
                .eventID(UUID.randomUUID())
                .eventCatalog(EventCatalog.TICKET_CREATED)
                .build();

        var eventBody = new TicketCreatedEvent(
                ticket.getTicketUUID().uuid(),
                ticket.getVisitorUUID().uuid()
        );

        try{
            rabbitTemplate.convertAndSend(RabbitMQModuleTopology.TICKET_EVENTS_FAN_OUT, "ticket.created",
                    EventMessage
                            .builder()
                            .eventHeader(eventHeader)
                            .eventBody(objectMapper
                                    .writeValueAsString(eventBody))
                            .build());

        } catch ( JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }
}
