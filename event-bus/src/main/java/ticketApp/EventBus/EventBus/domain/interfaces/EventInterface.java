package ticketApp.EventBus.EventBus.domain.interfaces;

import ticketApp.EventBus.Subscriber.domain.entity.SubscriberEntity;

public interface EventInterface {
    public void fireEvent(String eventName);
    public boolean subscribe(SubscriberEntity subscriberData, String eventName);
    public boolean unsubscribe(String suscriberName , String eventName);
}