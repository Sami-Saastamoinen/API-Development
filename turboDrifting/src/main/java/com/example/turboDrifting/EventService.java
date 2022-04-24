
package com.example.turboDrifting;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    
    @Autowired
    private EventRepository eventRepository;
    
    public List<Event> getEvents(){ 
        return this.eventRepository.findAll();
    }
    
    public void addEvent(String name, int repReq, int fee){
        this.eventRepository.save(new Event(name, repReq, fee));
    }
    
    public Event findEventByName(String eventName){
        return this.eventRepository.findByName(eventName).get(0);
    }
    
    @Transactional
    public void deleteEventByName(String name){
        this.eventRepository.deleteByName(name);
    }
}

