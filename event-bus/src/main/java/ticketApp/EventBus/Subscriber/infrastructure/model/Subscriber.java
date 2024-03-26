package ticketApp.EventBus.Subscriber.infrastructure.model;

import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ticketApp.EventBus.Subscriber.domain.entity.SubscriberEntity;
import ticketApp.EventBus.Subscriber.domain.interfaces.SubscriberInterface;

@SuperBuilder
@Getter
@Setter
@Builder
public class Subscriber extends SubscriberEntity implements SubscriberInterface {
    @Id
    private String id;

    public void fireEvent(){}
}