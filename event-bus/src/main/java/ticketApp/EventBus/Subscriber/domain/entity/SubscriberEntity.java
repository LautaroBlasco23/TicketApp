package ticketApp.EventBus.Subscriber.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

// Where to send messages.
@Getter
@Setter
@SuperBuilder
public class SubscriberEntity {
    protected String name;
    protected String host;
    protected String port;
}
