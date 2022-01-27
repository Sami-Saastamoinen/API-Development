package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.stereotype.Service;

@Service
public class ListMapService {
    public ArrayList<String> getNewList(){
        System.out.println("List Service");
        ArrayList<String> list = new ArrayList<>();
        list.add("hi");
        list.add("hello");
        list.add("greetings");
        return list;
    }
    
    public HashMap<String, String> getNewMap(){
        System.out.println("Map Service");
        HashMap<String, String> map = new HashMap<>();
        map.put("Helsinki", "Finland");
        map.put("Buenos Aires", "Argentina");
        map.put("Berlin", "Germany");
        return map;
    }
}
