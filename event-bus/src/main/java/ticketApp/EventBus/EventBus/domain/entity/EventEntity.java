package ticketApp.EventBus.EventBus.domain.entity;

import java.util.List;

import lombok.Data;
import ticketApp.EventBus.Producer.domain.entity.ProducerEntity;
import ticketApp.EventBus.Subscriber.infrastructure.model.Subscriber;

@Data
public class EventEntity {
    protected String name;
    protected ProducerEntity producer;
    protected List<Subscriber> listOfSubscribers;
}
