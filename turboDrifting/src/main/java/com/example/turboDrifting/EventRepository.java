
package com.example.turboDrifting;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventRepository extends JpaRepository<Event, Long>{
    ArrayList<Event> findByName(String name);
    Long deleteByName(String name);
}
