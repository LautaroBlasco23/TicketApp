package ticketApp.EventBus.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import ticketApp.EventBus.infrastructure.services.EventServices;

@RestController
@RequestMapping("/api/events")
public class EventController {
    
    @Autowired
    private EventServices eventServices;

    @PostMapping("/suscribe")
    public void suscribe(@RequestParam String eventName, HttpServletRequest request) {
        
    }

    @PostMapping("/unsuscribe")
    public void unSuscribe() {

    }

    @PostMapping("/fire")
    public void fireEvent() {
        
    }
}
