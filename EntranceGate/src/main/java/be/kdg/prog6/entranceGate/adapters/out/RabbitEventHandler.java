package be.kdg.prog6.entranceGate.adapters;

import be.kdg.prog6.common.events.EventMessage;
import be.kdg.prog6.common.facades.TicketEvent;
import be.kdg.prog6.entranceGate.adapters.config.RabbitMQModuleTopology;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class RabbitEventHandler {

        private final List<TicketEventHandler<? extends TicketEvent>> ticketEventHandler;
        private final Logger logger = LoggerFactory.getLogger(RabbitEventHandler.class);

        @RabbitListener(queues = RabbitMQModuleTopology.TICKET_EVENTS_QUEUE, messageConverter = "#{jackson2JsonMessageConverter}")
        public void receiveEventMessage(EventMessage eventMessage) {
            logger.info("Received event message: {}", eventMessage);

            ticketEventHandler.stream()
                    .filter(
                            ticketEventHandler ->
                                    ticketEventHandler.appliesTo(
                                            eventMessage.getEventHeader().getEventCatalog()
                                    )
                    )
                    .forEach(
                            ticketEventHandler ->
                                    ticketEventHandler.receive(eventMessage).handle(
                                            ticketEventHandler.map(eventMessage.getEventBody())
                                    )
                    );
        }
}
