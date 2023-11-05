package be.kdg.prog6.parkInformationSystem.adapters.in.amqp;

import be.kdg.prog6.common.events.EventCatalog;
import be.kdg.prog6.common.facades.refreshmentStand.RefreshmentStandCreatedEvent;
import be.kdg.prog6.common.facades.refreshmentStand.RefreshmentStandEvent;
import be.kdg.prog6.parkInformationSystem.adapters.in.RefreshmentStandEventHandler;
import be.kdg.prog6.parkInformationSystem.ports.In.RefreshmentStandCreatedUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RefreshmentStandCreatedAMQPAdapter implements RefreshmentStandEventHandler<RefreshmentStandCreatedEvent> {

    private final ObjectMapper objectMapper;
    private final RefreshmentStandCreatedUseCase refreshmentStandCreatedUseCase;

    private final Logger logger = LoggerFactory.getLogger(RefreshmentStandCreatedAMQPAdapter.class);


    @Override
    public boolean appliesTo(EventCatalog eventCatalog) {
        return EventCatalog.REFRESHMENT_STAND_CREATED == eventCatalog;
    }

    @Override
    public RefreshmentStandEvent map(String eventBody) {
        try{
            return objectMapper.readValue(eventBody, RefreshmentStandCreatedEvent.class);
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void handle(RefreshmentStandEvent refreshmentStandEventBody) {
        logger.info("Received refreshment stand created event: {}", refreshmentStandEventBody);
        refreshmentStandCreatedUseCase.createRefreshmentStand((RefreshmentStandCreatedEvent) refreshmentStandEventBody);
    }
}
