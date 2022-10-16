package com.jeonghyeon.javastudy.datastructure.mapstudy;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/datastructure/map")
public class MapController {

    @GetMapping("/test1")
    public void test1(){
        Map<String,Integer> linkedMap = new HashMap<>();
        linkedMap.put("b1",333);
        linkedMap.put("a1",222);
        linkedMap.put("d1",111);
        linkedMap.remove("d1");
        linkedMap.put("c1",555);
        linkedMap.put("d1",111);
        System.out.println(linkedMap);


        Map<String,Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("b1",333);
        linkedHashMap.put("a1",222);
        linkedHashMap.put("d1",111);
        linkedHashMap.put("e1",555);
        System.out.println(linkedHashMap);
        MapDto dto =new MapDto(linkedMap,linkedHashMap);

    }
}

