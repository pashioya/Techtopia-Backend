package be.keg.prog6.parkOperations.adapters.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQModuleTopology {


    public static final String RefreshmentStand_EVENTS_FAN_OUT = "refreshmentStand-events";



    @Bean
    FanoutExchange refreshmentStandEventsExchange() {
        return new FanoutExchange(RefreshmentStand_EVENTS_FAN_OUT);
    }

    @Bean
    Queue refreshmentStandEventsQueue() {
        return new Queue(RefreshmentStand_EVENTS_FAN_OUT);
    }


    @Bean
    Binding eventsBinding(FanoutExchange ticketEventsExchange, Queue ticketEventsQueue) {
        return BindingBuilder.bind(ticketEventsQueue).to(ticketEventsExchange);
    }
}
