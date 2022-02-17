package com.example.questingHeroes;

//import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestService {
    //private ArrayList<Quest> quests;
    
    @Autowired
    private HeroService heroService;
    
    @Autowired
    private QuestRepository questRepository;
    
    /*public QuestService(){
        System.out.println("Creating quests...");
        this.quests = new ArrayList<>();
        this.quests.add(new Quest("Steal Sauron's monocle", 15));
        this.quests.add(new Quest("Conquer Dragon Mountain", 10));
        this.quests.add(new Quest("Bake magic cookies", 3));
    }*/
    
    public List<Quest> getQuests(){ 
        return this.questRepository.findAll();
        //return this.quests;
    }
    
    public void addQuest(String name, int difficulty){
        this.questRepository.save(new Quest(name, difficulty));
        //this.quests.add(new Quest(name, difficulty));
    }
    
    public Quest findQuestByName(String questName){
        return this.questRepository.findByName(questName).get(0);
        /*for (Quest quest: quests){
            if (quest.getName().equals(questName)) {
                return quest;
            }
        }
        return null;*/
    }
    
    @Transactional
    public void deleteQuestByName(String name){
        this.questRepository.deleteByName(name);
        /*Quest quest = findQuestByName(name);
        this.quests.remove(quest);*/
    }
    
    public void tryQuest(String heroName, String questName) {
        Hero hero = heroService.findHeroByName(heroName);
        Quest quest = findQuestByName(questName);
        for (int i = 0; i < hero.getLevel(); i++) {
            int x = (int) (Math.random() * 20) + 1;
            if (x > quest.getDifficulty()) {
                hero.completeQuest();
                return;
            }
        }
        hero.failQuest();
    }
}

