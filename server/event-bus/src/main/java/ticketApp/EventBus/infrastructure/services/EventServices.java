package ticketApp.EventBus.infrastructure.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ticketApp.EventBus.infrastructure.models.Event;
import ticketApp.EventBus.infrastructure.models.Subscriber;
import ticketApp.EventBus.infrastructure.repository.EventRepository;

public class EventServices {
    
    @Autowired
    public EventRepository eventRepository;

    public void suscribe(String eventName, Subscriber newSub) {
        Event event = eventRepository.findByName(eventName);

        List<Subscriber> listOfSubs = event.getListOfSubscribers();
        // Adding sub from list.
        listOfSubs.add(newSub);
        // saving new list of subs.
        event.setListOfSubscribers(listOfSubs);

        // saving modified event.
        eventRepository.save(event);
    }

    public void unSuscribe(String eventName, Subscriber subToRemove) {
        Event event = eventRepository.findByName(eventName);

        List<Subscriber> listOfSubs = event.getListOfSubscribers();
        // removing sub from list.
        listOfSubs.remove(subToRemove);
        // saving new list of subs.
        event.setListOfSubscribers(listOfSubs);

        // saving modified event.
        eventRepository.save(event);
    }

    public void fireEvent(String eventName, String producerName) {

    }
}