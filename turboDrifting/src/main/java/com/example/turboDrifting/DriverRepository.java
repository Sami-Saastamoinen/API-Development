
package com.example.turboDrifting;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DriverRepository extends JpaRepository<Driver, Long> {
    ArrayList<Driver> findByName(String name);
}
