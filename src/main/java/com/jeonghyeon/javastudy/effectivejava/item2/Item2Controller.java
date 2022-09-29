package com.jeonghyeon.javastudy.effectivejava.item2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.jeonghyeon.javastudy.effectivejava.item2.NyPizza.Size.SMALL;
import static com.jeonghyeon.javastudy.effectivejava.item2.Pizza.Topping.*;

@RestController
@RequestMapping("/effective/item2")
public class Item2Controller {
    @GetMapping("/test2")
    public String test1(){
        NutritionFactsConstructor cocaCola = new NutritionFactsConstructor(240,8,100,0,35,27);
        return "test1";
    }

    @GetMapping("/test2")
    public String test2(){
        NutritionFactsSetter cocaCola = new NutritionFactsSetter();
        cocaCola.setServingSize(240);
        cocaCola.setServings(8);
        cocaCola.setCalories(100);
        cocaCola.setSodium(35);
        cocaCola.setCarbohydrate(27);
        return "test2";
    }

    @GetMapping("/test3")
    public String test3(){
        NutritionFactsBuilder cocaCola = new NutritionFactsBuilder.Builder(240,8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();
        return "test3";
    }

    @GetMapping("/test4")
    public String test4(){
        Pizza pizza = new NyPizza.Builder(SMALL).addTopping(SAUSAGE).addTopping(ONION).build();

        Pizza calzone = new Calzone.Builder().addTopping(HAM).sauceInside().build();

        return "test4";
    }
}

