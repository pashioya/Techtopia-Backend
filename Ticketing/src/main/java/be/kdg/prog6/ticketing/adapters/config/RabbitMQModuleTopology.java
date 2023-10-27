package be.kdg.prog6.ticketing.adapters.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQModuleTopology {


    public static final String TICKET_EVENTS_FAN_OUT = "ticket-events";


    @Bean
    FanoutExchange ticketsEventsExchange() {
        return new FanoutExchange(TICKET_EVENTS_FAN_OUT);
    }

    @Bean
    Queue ticketEventsQueue() {
        return new Queue(TICKET_EVENTS_FAN_OUT);
    }


    @Bean
    Binding eventsBinding(FanoutExchange ticketEventsExchange, Queue ticketEventsQueue) {
        return BindingBuilder.bind(ticketEventsQueue).to(ticketEventsExchange);
    }
}
