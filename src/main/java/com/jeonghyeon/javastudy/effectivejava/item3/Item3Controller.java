package com.jeonghyeon.javastudy.effectivejava.item3;

import com.jeonghyeon.javastudy.effectivejava.item2.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Supplier;

import static com.jeonghyeon.javastudy.effectivejava.item2.NyPizza.Size.SMALL;
import static com.jeonghyeon.javastudy.effectivejava.item2.Pizza.Topping.*;

@RestController
@RequestMapping("/effective/item3")
public class Item3Controller {
    @GetMapping("/test1")
    public String test1(){
        SingletonField instance = SingletonField.INSTANCE;
        return "test1";
    }
    @GetMapping("/test2")
    public String test2(){
        SingletonFactory instance = SingletonFactory.getInstance();

        Supplier<SingletonFactory> instanceSupplier = SingletonFactory::getInstance;
        SingletonFactory instance2 = instanceSupplier.get();

        return "test2";
    }
}

