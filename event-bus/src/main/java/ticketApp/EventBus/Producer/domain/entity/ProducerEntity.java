package ticketApp.EventBus.Producer.domain.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class ProducerEntity {
    protected String host;
    protected String port;
}
