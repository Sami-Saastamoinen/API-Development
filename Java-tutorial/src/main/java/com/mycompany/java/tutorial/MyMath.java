package com.mycompany.java.tutorial;


public class MyMath {
    //Ex 4. Metodille annetaan min ja max, ja palautetaan kokonaisluku näiden väliltä. 
    //Tee metodi omaan luokkaan MyMath.
    public static int randomInteger(int min, int max){
        int options = max - min + 1;
        int randomInt = (int) (Math.random() * options) + min;
        
        return randomInt;
    }
}
