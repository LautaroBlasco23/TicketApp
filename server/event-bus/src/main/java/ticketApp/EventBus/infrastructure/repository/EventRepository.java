package ticketApp.EventBus.infrastructure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ticketApp.EventBus.infrastructure.models.Event;

public interface EventRepository extends MongoRepository<Event, String> {
    
    public Event findByName(String eventName);
}
