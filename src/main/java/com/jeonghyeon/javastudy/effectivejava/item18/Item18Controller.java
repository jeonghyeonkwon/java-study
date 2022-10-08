package com.jeonghyeon.javastudy.effectivejava.item18;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/effective/item18")
public class Item18Controller {
    @GetMapping("/test1")
    public String test1(){
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(List.of("틱","탁탁","펑"));

        System.out.println("count : " + s.getAddCount());
        return "test1";
    }


}
