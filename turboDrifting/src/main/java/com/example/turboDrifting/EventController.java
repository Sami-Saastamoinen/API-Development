
package com.example.turboDrifting;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EventController {
    
    @Autowired
    private EventService eventService;
    
    @GetMapping("/events")
    public String getEvents(Model model){
        List<Event> events = eventService.getEvents();
        model.addAttribute("events", events);
        return "events";
    }
    
    @PostMapping("/events")
    public String addEvent(@RequestParam String eventName, int eventRepReq, int eventFee){
        eventService.addEvent(eventName, eventRepReq, eventFee);
        return "redirect:/events";
    }
    
    @PostMapping("/deleteevent")
    public String deleteEvent(@RequestParam String eventName){
        eventService.deleteEventByName(eventName);
        return "redirect:/events";
    }
}
