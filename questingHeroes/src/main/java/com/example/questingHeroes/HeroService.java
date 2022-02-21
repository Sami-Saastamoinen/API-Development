package com.example.questingHeroes;

//import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroService {
    //private ArrayList<Hero> heroes;
    
    /*public HeroService(){
        System.out.println("HeroService()");
        this.heroes = new ArrayList<>();
        Hero h1 = new Hero ("Aragorn", "Watering the White tree...", 43, 150, 9249);
        heroes.add(h1);
        heroes.add(new Hero ("Galadriel", "Hanging out in Lothlorien...", 8, 50, 649));
        heroes.add(new Hero ("Sir Lothar", "Being a knight", 99, 999, 999999999));
    }*/

    @Autowired
    private QuestService questService;
    
    @Autowired
    private HeroRepository heroRepository;
    
    public List<Hero> getHeroes() {
        return this.heroRepository.findAll();
        //return heroes;
    }

    public void addHero(String name) {
        this.heroRepository.save(new Hero (name));
        //this.heroes.add(new Hero (name));
    }
    
    public Hero findHeroByName(String heroName){
        return this.heroRepository.findByName(heroName).get(0);
        /*for (Hero hero: heroes){
            if (hero.getName().equals(heroName)) {
                return hero;
            }
        }
        return null;*/
    }
    
    public void tryQuest(String heroName, String questName) {
        Hero hero = this.findHeroByName(heroName);
        Quest quest = questService.findQuestByName(questName);
        for (int i = 0; i < hero.getLevel(); i++) {
            int x = (int) (Math.random() * 20) + 1;
            if (x > quest.getDifficulty()) {
                hero.completeQuest();
                this.heroRepository.save(hero);
                return;
            }
        }
        hero.failQuest();
        this.heroRepository.save(hero);
    }
}
