package ticketApp.EventBus.Producer.infrastructure.model;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ticketApp.EventBus.Producer.domain.entity.ProducerEntity;

@SuperBuilder
@Getter
@Setter
public class Producer extends ProducerEntity{
    @Id
    private String id;
}
