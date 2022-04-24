
package com.example.turboDrifting;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver extends AbstractPersistable<Long> {
    private String name;
    private String status;
    private int rep;
    private int dollar;
    private int wins;
    private int losses;

    public Driver(String name) {
        this.name = name;
        this.rep = 1;
        this.dollar = 50;
        this.wins = 0;
    }
    
    public void winEvent(int fee, int req){
        this.rep += (int) req / 2 + 1;
        this.dollar += 2 * fee;
        this.wins += 1;
        this.status = "You won the last event! Congrats!";
    }

    public void loseEvent(int fee, int req){
        this.rep -= req;
        this.dollar -= fee;
        this.losses += 1;
        
        if (this.rep <= 0) {
            this.status = "Woops...you lost all your rep! Career over!";
        } else if (this.dollar <= 0){
            this.status = "Woops...you lost all your money! Career over!";
        } else{
            this.status = "You lost the last event! Better luck next time!";
        }
    }

    public void invalidTry(int req, int fee) {
        if (this.rep < req) {
            this.status = "You cannot enter that race(too low rep)!";
        } else if (this.dollar < fee) {
            this.status = "You cannot enter that race(not enough money)!";
        }
    }
}