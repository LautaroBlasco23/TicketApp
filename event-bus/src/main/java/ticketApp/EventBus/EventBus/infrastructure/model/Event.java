package ticketApp.EventBus.EventBus.infrastructure.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import ticketApp.EventBus.EventBus.domain.entity.EventEntity;

@Document(collection="users")
@Builder
public class Event extends EventEntity{
    @Id
    private String id;
}
