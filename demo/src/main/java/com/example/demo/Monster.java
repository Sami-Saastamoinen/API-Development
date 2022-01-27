package com.example.demo;


public class Monster {
    private String name;
    private int age;
    private boolean scary;

    public Monster(String name, int age, boolean scary) {
        this.name = name;
        this.age = age;
        this.scary = scary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isScary() {
        return scary;
    }

    public void setScary(boolean scary) {
        this.scary = scary;
    }
}
