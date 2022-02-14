package com.example.questingHeroes;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hero extends AbstractPersistable<Long> {
    private String name;
    private String status;
    private int level;
    private int health;
    private int gold;

    public Hero(String name) {
        this.name = name;
        this.status = "This noobie is waiting for the first quest!";
        this.level = 1;
        this.health = 10;
        this.gold = 0;
    }
    
    public void completeQuest(){
        this.gold += 100;
        this.level += 1;
        this.status = "Completed a new quest! Yay!";
    }

    public void failQuest(){
        this.gold = 0;
        this.health -= 1;
        
        if (this.health == 0) {
            this.status = "Oooppps...hero died!";
        } else{
            this.status = "Oopps...quest failed!";
        }
    }
}