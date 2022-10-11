package com.jeonghyeon.javastudy.effectivejava.item20;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/effective/item20")
public class Item20Controller {
    @GetMapping("/test1")
    public String test1(){
        ChildrenClass childrenClass = new ChildrenClass();
        childrenClass.test1();
        childrenClass.test2();
        return "test1";
    }
}
