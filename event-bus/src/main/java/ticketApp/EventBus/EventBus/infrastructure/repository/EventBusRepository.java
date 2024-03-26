package ticketApp.EventBus.EventBus.infrastructure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ticketApp.EventBus.EventBus.infrastructure.model.Event;

import java.util.Optional;

public interface EventBusRepository extends MongoRepository<Event, String> {
    Optional<Event> findFirstByName(String eventName);
}