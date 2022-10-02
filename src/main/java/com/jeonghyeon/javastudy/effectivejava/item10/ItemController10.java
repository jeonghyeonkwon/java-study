package com.jeonghyeon.javastudy.effectivejava.item10;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/effective/item10")
public class ItemController10 {
    @GetMapping("/test1")
    public String test1(){

        return "test1";
    }
}
