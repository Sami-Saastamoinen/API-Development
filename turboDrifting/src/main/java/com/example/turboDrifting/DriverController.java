
package com.example.turboDrifting;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DriverController {
    
    @Autowired
    private DriverService driverService;
    
    @Autowired
    private EventService eventService;
    
    @GetMapping("/drivers")
    public String getDrivers(Model model){
        List<Driver> drivers = driverService.getDrivers();
        model.addAttribute("drivers", drivers);
        return "drivers";
    }
    
    @PostMapping("/drivers")
    public String addDriver(@RequestParam String driverName){
        System.out.println("Got: " + driverName);
        driverService.addDriver(driverName);
        return "redirect:/drivers";
    }
    
    @GetMapping("drivers/{driverName}")
    public String getDriverInfo(@PathVariable String driverName, Model model){
        Driver driver = driverService.findDriverByName(driverName);
        List<Event> events = eventService.getEvents();
        model.addAttribute("driver", driver);
        model.addAttribute("events", events);
        return "driver";
    }
    
    @PostMapping("/tryevent")
    public String tryEvent(@RequestParam String driverName, String eventName){
        driverService.tryEvent(driverName, eventName);
        return "redirect:/drivers/" + driverName;
    }
}
