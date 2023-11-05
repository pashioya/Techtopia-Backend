package be.kdg.prog6.parkInformationSystem.adapters.in;

import be.kdg.prog6.common.events.EventMessage;
import be.kdg.prog6.common.facades.attraction.AttractionEvent;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import be.kdg.prog6.parkInformationSystem.adapters.config.RabbitMQModuleTopology;

import java.util.List;
    @AllArgsConstructor
    @Component
    public class RabbitEventHandler {

        private final List<AttractionEventHandler<? extends AttractionEvent>> attractionEventHandlers;
        private final Logger logger = LoggerFactory.getLogger(RabbitEventHandler.class);

        @RabbitListener(queues = RabbitMQModuleTopology.ATTRACTION_CREATED, messageConverter = "#{jackson2JsonMessageConverter}")
        public void receiveEventMessage(EventMessage eventMessage) {
            logger.info("Received event message: {}", eventMessage);
            attractionEventHandlers.stream()
                    .filter(
                            attractionEventHandler ->
                                    attractionEventHandler.appliesTo(
                                            eventMessage.getEventHeader().getEventCatalog()
                                    )
                    )
                    .forEach(
                            attractionEventHandler ->
                                    attractionEventHandler.receive(eventMessage).handle(
                                            attractionEventHandler.map(eventMessage.getEventBody())
                                    )
                    );
        }

}
