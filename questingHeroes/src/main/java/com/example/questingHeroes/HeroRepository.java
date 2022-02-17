package com.example.questingHeroes;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HeroRepository extends JpaRepository<Hero, Long> {
    ArrayList<Hero> findByName(String name);
}
