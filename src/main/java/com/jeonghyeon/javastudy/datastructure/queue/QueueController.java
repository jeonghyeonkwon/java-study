package com.jeonghyeon.javastudy.datastructure.queue;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

@RestController
@RequestMapping("/datastructure/queue")
public class QueueController {

    @GetMapping("/test1")
    public void test1(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);

        for (Integer integer : queue) {
            System.out.println(integer);
        }

    }

    @GetMapping("/test2")
    public void test2(){
        Deque<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);

        for (Integer integer : queue) {
            System.out.println(integer);
        }

    }
    @GetMapping("/test2")
    public void test3(){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);

        for (Integer integer : queue) {
            System.out.println(integer);
        }

    }


}
