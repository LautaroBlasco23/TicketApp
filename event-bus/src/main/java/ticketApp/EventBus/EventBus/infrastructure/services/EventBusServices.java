package ticketApp.EventBus.EventBus.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import ticketApp.EventBus.EventBus.domain.interfaces.EventInterface;
import ticketApp.EventBus.EventBus.infrastructure.model.Event;
import ticketApp.EventBus.EventBus.infrastructure.repository.EventBusRepository;
import ticketApp.EventBus.Subscriber.domain.entity.SubscriberEntity;
import ticketApp.EventBus.Subscriber.infrastructure.model.Subscriber;

@Service
public class EventBusServices implements EventInterface {
    
    @Autowired
    private EventBusRepository eventBusRepository;

    public boolean subscribe(SubscriberEntity subscriberData, String eventName) {
        Optional<Event> queryResult = eventBusRepository.findFirstByName(eventName);
        
        if (queryResult == null) {
            return false;
        } 

        Event eventToModify = queryResult.get();

        // checking if suscriber data is not empty (basic check).
        if ((subscriberData.getHost() == null) || (subscriberData.getPort()) == null) {
            return false;
        }

        // Creation of new Subscriber object (to save it in db).
        Subscriber newSubscriber = Subscriber.builder()
            .host(subscriberData.getHost())
            .port(subscriberData.getPort())
            .build();

        // saving new subscriber into event's list of suscribers.
        eventToModify.getListOfSubscribers().add(newSubscriber);

        // Finally save the modified event.
        eventBusRepository.save(eventToModify);
        return true;
    }

    public boolean unsubscribe(String suscriberName , String eventName) {
        Optional<Event> queryResult = eventBusRepository.findFirstByName(eventName);

        if (queryResult == null) {
            return false;
        } 

        Event eventToModify = queryResult.get();

        // We search for our subscriber to remove.
        Subscriber subscriberToRemove = null;
        for (Subscriber sub: eventToModify.getListOfSubscribers()) {
            if (sub.getName() == suscriberName) {
                subscriberToRemove = sub;
            }
        }

        // if not founded, return false.
        if (subscriberToRemove == null) {
            return false;
        }

        eventToModify.getListOfSubscribers().remove(subscriberToRemove);
        eventBusRepository.save(eventToModify);
        return true;
    }

    public void fireEvent(String eventName) {
        Optional<Event> queryResult = eventBusRepository.findFirstByName(eventName);
        
        // If event is not in database. It will return an exception.
        Event eventToModify = queryResult.get();

        // we fire the event in all suscribers
        // This is going to be usefull when we want to create the specific events.
        for (Subscriber sub: eventToModify.getListOfSubscribers()) {
            sub.fireEvent();
        }
    }
}
