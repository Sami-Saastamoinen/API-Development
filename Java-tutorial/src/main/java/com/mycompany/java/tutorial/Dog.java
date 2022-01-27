package com.mycompany.java.tutorial;


public class Dog {
    private String name;
    private int age;

    public Dog(String name){
        this.name = name;
        this.age = 0;
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    
    public void play(Dog friend){
        System.out.println(name + " is playing with " + friend.getName() + "!");
    }
}
