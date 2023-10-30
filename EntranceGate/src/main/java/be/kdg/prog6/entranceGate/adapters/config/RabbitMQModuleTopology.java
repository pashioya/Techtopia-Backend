package be.kdg.prog6.entranceGate.adapters.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQModuleTopology {

    public static final String TICKET_EVENTS_FAN_OUT = "ticket-events";
    public static final String TICKET_EVENTS_QUEUE = "ticket-events-queue";
    public static final String CHECK_IN_OUT_FAN_OUT = "check-io-events";

    @Bean
    FanoutExchange ticketEventsExchange() {
        return new FanoutExchange(TICKET_EVENTS_FAN_OUT);
    }

    @Bean
    Queue ticketEventsQueue() {
        return new Queue(TICKET_EVENTS_QUEUE);
    }

    @Bean
    Binding ticketEventsBinding(FanoutExchange ticketEventsExchange, Queue ticketEventsQueue) {
        return BindingBuilder.bind(ticketEventsQueue).to(ticketEventsExchange);
    }

    @Bean
    FanoutExchange checkInOutEventsExchange() {
        return new FanoutExchange(CHECK_IN_OUT_FAN_OUT);
    }

}
