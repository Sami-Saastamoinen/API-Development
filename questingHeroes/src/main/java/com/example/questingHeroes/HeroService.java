package com.example.questingHeroes;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class HeroService {
    
    private ArrayList<Hero> heroes;
    
    public HeroService(){
        System.out.println("HeroService()");
        this.heroes = new ArrayList<>();
        Hero h1 = new Hero ("Aragorn", "Watering the White tree...", 43, 150, 9249);
        heroes.add(h1);
        heroes.add(new Hero ("Galadriel", "Hanging out in Lothlorien...", 8, 50, 649));
        heroes.add(new Hero ("Sir Lothar", "Being a knight", 99, 999, 999999999));
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void addHero(String name) {
        this.heroes.add(new Hero (name));
    }
    
    public Hero findHeroByName(String heroName){
        for (Hero hero: heroes){
            if (hero.getName().equals(heroName)) {
                return hero;
            }
        }
        return null;
    }
    
}
