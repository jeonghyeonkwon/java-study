package com.jeonghyeon.javastudy.datastructure.liststudy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/datastructure/list")
public class ListController {
    @GetMapping("/to-array")
    public Object test1(){
        List<String> list =new ArrayList<>();
        list.add("str1");
        list.add("str2");
        list.add("str3");
        list.add("str4");
        list.add("str5");

        String[] arr = new String[19];

        String[] strings = list.toArray(arr);
        System.out.println(strings.length
        );
//        for (int i=5; i<=9;i++){
//            strings[i] = "str"+i;
//
//        }
        return strings;
    }
    @GetMapping("/remove")
    public void test2(){
        List<String> list =new ArrayList<>();
        list.add("str1");
        list.add("str2");
        list.add("str3");
        list.add("str4");
        list.add("str5");
        list.remove("str6");
        System.out.println(list.remove("str7"));
    }
    @GetMapping("/contains-all")
    public Object test3(){
        List<String> list =new ArrayList<>();
        list.add("str1");
        list.add("str2");
        list.add("str3");
        list.add("str4");
        list.add("str5");

        List<String> list1 =new ArrayList<>();
        list1.add("str2");
        list1.add("str15");

        list1.add("str3");
        System.out.println(list.containsAll(list1));
        return list.containsAll(list1);
    }
}
