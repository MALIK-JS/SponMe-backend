package com.sponme.SponMe.appevent;

import com.sponme.SponMe.registration.RegistrationRequest;
import com.sponme.SponMe.registration.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//path = "api/v1/event"
@RestController
@RequestMapping
@AllArgsConstructor
public class AppEventController {

    private AppEventService appEventService;

    // return the list of all events "/viewall"
    @GetMapping("api/v1/event/viewall")
    public List<AppEvent> findAll(){
        return appEventService.findAll();
    }

    @GetMapping
    @CrossOrigin( origins = "http://localhost:3000")
    public String show(){
        return "Succes";
    }

    // return a specific event using on the id
    @GetMapping("api/v1/event/{eventId}")
    public AppEvent getEvent(@PathVariable int eventId ){
        AppEvent theEvent = appEventService.findById(eventId);
        if (theEvent == null ){
            throw new RuntimeException("Event id not found - " + eventId);
        }
        return theEvent;
    }

    // adding an event
    @PostMapping("api/v1/event/")
    public AppEvent addEvent(@RequestBody AppEvent event ){
        event.setId(0);
        appEventService.save(event);
        return event;
    }

    @DeleteMapping("/{eventId}")
    public String deleteEvent(@PathVariable int eventId ){
        AppEvent theEvent = appEventService.findById(eventId);
        if (theEvent == null ){
            throw new RuntimeException("Event id not found - " + eventId);
        }
        appEventService.deleteById(eventId);
        return "The event has been deleted "+eventId;
    }


}