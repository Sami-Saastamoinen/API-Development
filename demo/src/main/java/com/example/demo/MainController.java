package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    
    @Autowired
    private MonsterService monsterService;
    
    @Autowired
    private ListMapService listMapService;

    //localhost:8080
    @GetMapping("/")
    @ResponseBody
    public String greet(){
        System.out.println("greet()");
        return "Greetings from server!";
    }
    
    //localhost:8080/hello
    @GetMapping("/hello")
    @ResponseBody
    public String sayHello(){
        System.out.println("sayHello()");
        return "Hellooo!";
    }
    
    //localhost:8080/hello/again
    @GetMapping("/hello/again")
    @ResponseBody
    public String sayHelloAgain(){
        System.out.println("sayHelloAgain()");
        return "Hello again!";
    }
    
    //localhost:8080/helloname?name=Sami
    @GetMapping("/helloname")
    @ResponseBody
    public String sayHelloWithName(@RequestParam String name){
        System.out.println("sayHelloWithName()+" + name);
        return "Hello " + name + "!";
    }
    
    //localhost:8080/hello/Sami
    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHelloWithPath(@PathVariable String name){
        System.out.println("sayHelloWithPath()+" + name);
        return "Hello " + name + "!";
    }
    
    //localhost:8080/list
    @GetMapping("/list")
    @ResponseBody
    public ArrayList<String> getList(){
        System.out.println("getList()");
        return listMapService.getNewList();
    }
    
    //localhost:8080/map
    @GetMapping("/map")
    @ResponseBody
    public HashMap<String, String> getMap(){
        System.out.println("getMap()");
        //1-line return
        return listMapService.getNewMap();
    }
    
    //localhost:8080/monster
    @GetMapping("/monster")
    @ResponseBody
    public Monster getMonster(){
        System.out.println("getMonster()");
        //2-line return
        Monster monster = monsterService.getNewMonster();
        return monster;
    }
    
    @PostMapping("/monster")
    @ResponseBody
    public Monster createMonster(@RequestBody Monster m){
        System.out.println("createMonster()");
        System.out.println(m.getName() + " " + m.getAge() + " " + m.isScary());
        return m;
    }
}
