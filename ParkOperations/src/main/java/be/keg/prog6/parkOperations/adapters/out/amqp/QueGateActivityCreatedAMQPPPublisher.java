package be.keg.prog6.parkOperations.adapters.out.amqp;

import be.kdg.prog6.common.events.EventHeader;
import be.kdg.prog6.common.events.EventCatalog;
import be.kdg.prog6.common.events.EventMessage;
import be.kdg.prog6.common.facades.queGate.QueGateActivityCreated;
import be.keg.prog6.parkOperations.adapters.out.db.QueGateRepository;
import be.keg.prog6.parkOperations.domain.TicketQueGateActivity;
import be.keg.prog6.parkOperations.ports.out.CreateTicketQueGateActivityPort;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import be.keg.prog6.parkOperations.adapters.config.RabbitMQModuleTopology;

import java.util.UUID;

@Component
@AllArgsConstructor
public class QueGateActivityCreatedAMQPPPublisher implements CreateTicketQueGateActivityPort {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;
    private final Logger logger = LoggerFactory.getLogger(QueGateActivityCreatedAMQPPPublisher.class);

    private final QueGateRepository queGateRepository;


    @Override
    public void createTicketQueGateActivity(TicketQueGateActivity ticketQueGateActivity){
        logger.info("Publishing que gate activity created event");

        var eventHeader = EventHeader.builder().eventID(UUID.randomUUID()).eventCatalog(EventCatalog.QUE_GATE_ACTIVITY_CREATED).build();
        var eventBody = new QueGateActivityCreated(
                ticketQueGateActivity.ticketUUID(),
//                must be the attractionUUID, not the queGateUUID. other bounded contexts aren't aware of que gates.
                queGateRepository.findById(ticketQueGateActivity.queGateUUID()).get().getAttractionUUID(),
                ticketQueGateActivity.ticketAction()
        );

        try {
            rabbitTemplate.convertAndSend(RabbitMQModuleTopology.QUE_GATE_EVENTS,
                    "que-gate.events",
                    EventMessage.builder().eventHeader(eventHeader)
                            .eventBody(objectMapper.writeValueAsString(eventBody))
                            .build()
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
