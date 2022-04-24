
package com.example.turboDrifting;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    @Autowired
    private EventService eventService;
    
    @Autowired
    private DriverRepository driverRepository;
    
    public List<Driver> getDrivers() {
        return this.driverRepository.findAll();
        //return heroes;
    }

    public void addDriver(String name) {
        this.driverRepository.save(new Driver (name));
        //this.heroes.add(new Hero (name));
    }
    
    public Driver findDriverByName(String heroName){
        return this.driverRepository.findByName(heroName).get(0);
    }
    
    public void tryEvent(String driverName, String eventName) {
        Driver driver = this.findDriverByName(driverName);
        Event event = eventService.findEventByName(eventName);
        if (driver.getRep() < event.getRepReq() || driver.getDollar() < event.getFee()) {
           driver.invalidTry(event.getRepReq(), event.getFee());
           this.driverRepository.save(driver);
           return;
        }
        for (int i = 0; i < 10; i++) {
            int x = (int) (Math.random() * event.getRepReq()) + 1;
            if (x >= event.getRepReq()) {
                driver.winEvent(event.getFee(), event.getRepReq());
                this.driverRepository.save(driver);
                return;
            }
        }
        driver.loseEvent(event.getFee(), event.getRepReq());
        this.driverRepository.save(driver);
    }
}
