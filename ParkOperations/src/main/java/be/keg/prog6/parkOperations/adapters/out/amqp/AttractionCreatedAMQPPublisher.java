package be.keg.prog6.parkOperations.adapters.out.amqp;

import be.kdg.prog6.common.events.EventCatalog;
import be.kdg.prog6.common.events.EventHeader;
import be.kdg.prog6.common.events.EventMessage;
import be.kdg.prog6.common.facades.attraction.AttractionCreatedEvent;
import be.keg.prog6.parkOperations.adapters.config.RabbitMQModuleTopology;
import be.keg.prog6.parkOperations.domain.Attraction;
import be.keg.prog6.parkOperations.ports.out.CreateAttractionPort;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class AttractionCreatedAMQPPublisher implements CreateAttractionPort {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;
    private final Logger logger = LoggerFactory.getLogger(AttractionCreatedAMQPPublisher.class);

    @Override
    public void createAttraction(Attraction attraction) {
        logger.info("Publishing attraction created event");

        var eventHeader = EventHeader.builder().eventID(UUID.randomUUID()).eventCatalog(EventCatalog.ATTRACTION_CREATED).build();
        var eventBody = new AttractionCreatedEvent(
                attraction.getAttractionUUID().uuid(),
                attraction.getQueGateUUID().uuid(),
                attraction.getName(),
                attraction.getDescription()
        );

        try{
            rabbitTemplate.convertAndSend(RabbitMQModuleTopology.ATTRACTION_CREATED,
                    "attraction.created",
                    EventMessage.builder().eventHeader(eventHeader)
                            .eventBody(objectMapper.writeValueAsString(eventBody))
                            .build());
        }
        catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }
}
