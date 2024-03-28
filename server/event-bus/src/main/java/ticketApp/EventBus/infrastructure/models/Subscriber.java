package ticketApp.EventBus.infrastructure.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Subscriber {
    private String url;
}
