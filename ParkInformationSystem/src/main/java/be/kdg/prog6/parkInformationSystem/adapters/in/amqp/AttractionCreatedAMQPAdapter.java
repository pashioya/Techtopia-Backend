package be.kdg.prog6.parkInformationSystem.adapters.in.amqp;

import be.kdg.prog6.common.events.EventCatalog;
import be.kdg.prog6.common.facades.attraction.AttractionCreatedEvent;
import be.kdg.prog6.common.facades.attraction.AttractionEvent;
import be.kdg.prog6.parkInformationSystem.adapters.in.AttractionEventHandler;
import be.kdg.prog6.parkInformationSystem.ports.In.AttractionCreatedUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
public class AttractionCreatedAMQPAdapter implements AttractionEventHandler<AttractionCreatedEvent> {

    private final ObjectMapper objectMapper;
    private final AttractionCreatedUseCase attractionCreatedUseCase;
    private final Logger logger = LoggerFactory.getLogger(AttractionCreatedAMQPAdapter.class);


    @Override
    public boolean appliesTo(EventCatalog eventCatalog) {
        return EventCatalog.ATTRACTION_CREATED == eventCatalog;
    }

    @Override
    public AttractionEvent map(String eventBody) {
        try {
            return objectMapper.readValue(eventBody, AttractionCreatedEvent.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void handle(AttractionEvent attractionEventBody) {
        logger.info("Received attraction created event: {}", attractionEventBody);
        attractionCreatedUseCase.createAttraction((AttractionCreatedEvent) attractionEventBody);
    }


}
