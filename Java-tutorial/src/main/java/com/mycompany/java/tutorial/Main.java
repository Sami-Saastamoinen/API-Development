package com.mycompany.java.tutorial;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        
        //ArrayList (import java.util.ArrayList)
        
        //Ex 1.
        helloWorld();
        
        //Ex 2.
        String text = "stringstring";
        printString(text);
        
        //Ex 3.
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(24);
        numbers.add(55);
        numbers.add(92);
        numbers.add(75);
        numbers.add(13);
        numbers.add(27);
        numbers.add(85);
        numbers.add(10);
        
        double avg = intAverage(numbers);
        System.out.println(avg);
        
        //Ex 4.
        System.out.println(MyMath.randomInteger(654, 876));
        
        //Ex 5.
        ArrayList<String> words = new ArrayList<>();
        words.add("hi");
        words.add("hello");
        words.add("greetings");
        
        String longest = longestString(words);
        System.out.println(longest);
        
        //Dogs
        Dog dog1 = new Dog("Hilla");
        Dog dog2 = new Dog("Malla", 3);
        
        dog1.play(dog2);
        
    }
    
    //Ex 1. Metodi printtaa Hello World!
    public static void helloWorld(){
        System.out.println("Hello world");
    }
    
    //Ex 2. Metodille annetaan merkkijono, ja 
    //tulostetaan merkkijonon kirjaimet allekkain.
    public static void printString(String text){
        for (int i = 0; i < text.length(); i++) {
            System.out.println(text.charAt(i));
        }
    }
    
    //Ex 3. Metodille annetaan int-tyyppinen taulukko, ja 
    //palautetaan lukujen keskiarvo.
    public static double intAverage(ArrayList<Integer> numbers){
        double sum = 0;
        for (int i : numbers) {
            sum += i;
        }
        sum = sum / numbers.size();
        return sum;
    }

    //Ex 4. Metodille annetaan min ja max, ja palautetaan kokonaisluku näiden väliltä.
    //Tee metodi omaan luokkaan MyMath.

    //Ex 5. Metodille annetaan String-tyyppinen lista ja 
    //palautetaan listan pisin merkkijono.
    public static String longestString(ArrayList<String> words){
        String longest = words.get(0);
        
        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        
        return longest;
    }
}
