package com.jeonghyeon.javastudy.effectivejava.item1;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@RequestMapping("/effective/item1")
public class Item1Controller {
    @GetMapping("/test1")
    public String test1(){
        // 유저 생성1
        User user1 = new User("유저1",10,UserRole.BASIC);
        System.out.println(user1);

        // 유저 생성2
        User user2 = User.ofAdmin("유저2",11);
        System.out.println(user2);

        User user3 = User.ofBasic("유저3",12);
        System.out.println(user3);

        return "test1";
    }
    @GetMapping("/test2")
    public String test2(){
        Parent child = ChildInter.child();
        System.out.println(child);
        return "test2";
    }
}
