package be.kdg.prog6.entranceGate.adapters.in.amqp;

import be.kdg.prog6.common.facades.TicketEvent;
import be.kdg.prog6.common.events.EventCatalog;
import be.kdg.prog6.common.facades.TicketCreatedTicketEvent;
import be.kdg.prog6.entranceGate.adapters.TicketEventHandler;
import be.kdg.prog6.entranceGate.ports.in.ScannedTicketCreatedUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class TicketCreatedAMQPAdapter implements TicketEventHandler<TicketCreatedTicketEvent> {

    private final ObjectMapper objectMapper;
    private final ScannedTicketCreatedUseCase scannedTicketCreatedUseCase;
    private final Logger logger = LoggerFactory.getLogger(TicketCreatedAMQPAdapter.class);

    @Override
    public boolean appliesTo(EventCatalog eventCatalog) {
        return EventCatalog.TICKET_CREATED == eventCatalog;
    }

    @Override
    public TicketCreatedTicketEvent map(String eventBody) {
        try {
            return objectMapper.readValue(eventBody, TicketCreatedTicketEvent.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void handle(TicketEvent ticketTicketEventBody) {
        logger.info("Received ticket created event: {}", ticketTicketEventBody);
        scannedTicketCreatedUseCase.createTicket((TicketCreatedTicketEvent) ticketTicketEventBody);
    }
}
