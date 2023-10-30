package be.kdg.prog6.entranceGate.adapters.out.amqp;

import be.kdg.prog6.common.events.EventCatalog;
import be.kdg.prog6.common.events.EventHeader;
import be.kdg.prog6.common.events.EventMessage;
import be.kdg.prog6.common.facades.TicketActivityCreatedEvent;
import be.kdg.prog6.entranceGate.adapters.config.RabbitMQModuleTopology;
import be.kdg.prog6.entranceGate.domain.ScannedTicket;
import be.kdg.prog6.entranceGate.domain.TicketActivity;
import be.kdg.prog6.entranceGate.ports.out.ScannedTicketActivityCreatePort;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class ScannedTicketActivityAMQPPublisher implements ScannedTicketActivityCreatePort {
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public void createScannedTicketActivity(ScannedTicket.TicketUUID ticketUUID, TicketActivity ticketActivity) {
        var eventHeader = EventHeader.builder()
                .eventID(UUID.randomUUID())
                .eventCatalog(EventCatalog.TICKET_CHECKED_IN_OUT)
                .build();
        var eventBody = new TicketActivityCreatedEvent(
                ticketActivity.uuid(),
                ticketUUID.uuid(),
                ticketActivity.pit(),
                ticketActivity.action()
        );


        try{
            rabbitTemplate.convertAndSend(
                    RabbitMQModuleTopology.CHECK_IN_OUT_FAN_OUT,
                    "ticket.checkInOut",
                    EventMessage.builder()
                            .eventHeader(eventHeader)
                            .eventBody(objectMapper.writeValueAsString(eventBody))
                            .build()
            );
        }
        catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }
}
