package com.example.questingHeroes;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class HeroService {
    
    private ArrayList<String> heroes;
    
    public HeroService(){
        System.out.println("HeroService()");
        this.heroes = new ArrayList<>();
        heroes.add("Aragorn");
        heroes.add("Galadriel");
        heroes.add("Sir Lothar");
    }

    public ArrayList<String> getHeroes() {
        return heroes;
    }
    
    
}
