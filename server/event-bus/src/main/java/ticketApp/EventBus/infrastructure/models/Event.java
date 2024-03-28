package ticketApp.EventBus.infrastructure.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Document(collection = "events")
@Data
@Builder
public class Event {
    
    @Id
    private String id;

    private String eventName;
    private List<Subscriber> listOfSubscribers;
    private Producer producer;
}
