package be.kdg.prog6.entranceGate.adapters.in.amqp;

import be.kdg.prog6.common.events.Event;
import be.kdg.prog6.common.events.EventCatalog;
import be.kdg.prog6.common.facades.TicketCreatedEvent;
import be.kdg.prog6.entranceGate.adapters.TicketEventHandler;
import be.kdg.prog6.entranceGate.ports.in.ScannedTicketCreatedUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class TicketCreatedAMQPAdapter implements TicketEventHandler<TicketCreatedEvent>{

    private final ObjectMapper objectMapper;
    private final ScannedTicketCreatedUseCase scannedTicketCreatedUseCase;

    @Override
    public boolean appliesTo(EventCatalog eventCatalog) {
        return EventCatalog.TICKET_CREATED == eventCatalog;
    }

    @Override
    public TicketCreatedEvent map(String eventBody) {
        try {
            return objectMapper.readValue(eventBody, TicketCreatedEvent.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void handle(Event ticketEventBody) {
        scannedTicketCreatedUseCase.createTicket((TicketCreatedEvent) ticketEventBody);
    }
}
