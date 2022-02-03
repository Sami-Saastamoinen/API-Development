package com.example.questingHeroes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hero {
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

}