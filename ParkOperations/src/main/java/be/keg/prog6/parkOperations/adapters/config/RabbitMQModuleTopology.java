package be.keg.prog6.parkOperations.adapters.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQModuleTopology {

    public static final String REFRESHMENT_STAND_CREATED = "refreshment-stand.created";
    public static final String ATTRACTION_CREATED = "attraction.created";

    public static final String QUE_GATE_EVENTS = "que-gate.events";


    @Bean
    Queue attractionEventsQueue() {
        return new Queue(ATTRACTION_CREATED);
    }

    @Bean
    FanoutExchange attractionEventsExchange() {
        return new FanoutExchange(ATTRACTION_CREATED);
    }

    @Bean
    FanoutExchange refreshmentStandCreatedExchange() {
        return new FanoutExchange(REFRESHMENT_STAND_CREATED);
    }

    @Bean
    Queue refreshmentStandCreatedQueue() {
        return new Queue(REFRESHMENT_STAND_CREATED);
    }
    @Bean
    FanoutExchange queGateEventsExchange() {
        return new FanoutExchange(QUE_GATE_EVENTS);  // Naming consistency with "events"
    }

    @Bean
    Queue queGateEventsQueue() {
        return new Queue(QUE_GATE_EVENTS);  // Naming consistency with "events"
    }

    @Bean
    Binding queGateEventsBinding(FanoutExchange queGateEventsExchange, Queue queGateEventsQueue) {
        return BindingBuilder.bind(queGateEventsQueue).to(queGateEventsExchange);
    }

    @Bean
    Binding refreshmentStandCreatedBinding(FanoutExchange refreshmentStandCreatedExchange, Queue refreshmentStandCreatedQueue) {
        return BindingBuilder.bind(refreshmentStandCreatedQueue).to(refreshmentStandCreatedExchange);
    }

    @Bean
    Binding attractionEventsBinding(FanoutExchange attractionEventsExchange, Queue attractionEventsQueue) {
        return BindingBuilder.bind(attractionEventsQueue).to(attractionEventsExchange);
    }
}
