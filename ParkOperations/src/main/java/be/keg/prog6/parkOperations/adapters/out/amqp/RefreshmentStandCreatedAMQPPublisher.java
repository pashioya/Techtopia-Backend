package be.keg.prog6.parkOperations.adapters.out.amqp;

import be.kdg.prog6.common.events.EventCatalog;
import be.kdg.prog6.common.events.EventHeader;
import be.kdg.prog6.common.facades.refreshmentStand.RefreshmentStandCreatedEvent;
import be.keg.prog6.parkOperations.adapters.config.RabbitMQModuleTopology;
import be.keg.prog6.parkOperations.domain.RefreshmentStand;
import be.keg.prog6.parkOperations.ports.out.CreateRefreshmentStandPort;
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
public class RefreshmentStandCreatedAMQPPublisher implements CreateRefreshmentStandPort {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;
    private final Logger logger = LoggerFactory.getLogger(RefreshmentStandCreatedAMQPPublisher.class);

    @Override
    public void createRefreshmentStand(RefreshmentStand refreshmentStand) {
        logger.info("Publishing refreshment stand created event");
        var eventHeader = EventHeader.builder().eventID(UUID.randomUUID()).eventCatalog(EventCatalog.REFRESHMENT_STAND_CREATED).build();
        var eventBody = new RefreshmentStandCreatedEvent(
                refreshmentStand.getRefreshmentStandUUID().uuid(),
                refreshmentStand.getName(),
                refreshmentStand.getDescription(),
                refreshmentStand.getLocation()
        );
        try{
            rabbitTemplate.convertAndSend(RabbitMQModuleTopology.RefreshmentStand_EVENTS_FAN_OUT, "refreshmentStand.created", objectMapper.writeValueAsString(eventBody));
        }
        catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }
}
