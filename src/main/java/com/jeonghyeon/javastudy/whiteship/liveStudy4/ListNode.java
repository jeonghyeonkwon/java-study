package com.jeonghyeon.javastudy.whiteship.liveStudy4;
/*
TODO 1. LinkedList에 대해 공부하세요
   2. 정수를 저장하는 ListNode클래스를 구현하세요
   3. ListNode add(ListNode head, ListNode nodeToAdd, int position)를 구현하세요
   4. ListNode remove(ListNode head, int positionToRemove)를 구현하세요
   5. boolean contains(ListNode head, ListNode nodeToCheck)를 구현하세요
* */
public class ListNode {

    int data;
    ListNode next;

    public ListNode(int data){
        this.data = data;
        this.next = null;
    }

    ListNode add(ListNode head, ListNode nodeToAdd, int position){
        /*
        * 머리 노드의 추가할 위치 전 까지 노드 찾기
        * */
        ListNode listNode = head;
        for(int i=0; i < position - 1 ;i++){
            listNode = head.next;
        }

        /*
        * 추가 할 노드 끼우기
        * */
        nodeToAdd.next = listNode.next;
        listNode.next = nodeToAdd;
        return head;
    }

    ListNode remove(ListNode head, int positionToRemove){
        ListNode listNode = head;

        if(positionToRemove == 0){
            ListNode delete = listNode;
            head = listNode.next;
            delete.next = null;
            return delete;
        }

        for(int i = 0; i < positionToRemove -1; i++){
            listNode = listNode.next;
        }

        ListNode delete = listNode.next;
        listNode.next = delete.next;
        delete.next = null;
        return delete;
    }

    boolean contains(ListNode head, ListNode nodeToCheck){
        while(head.next!=null){
            if(head.next == nodeToCheck)
                return true;
            head = head.next;
        }
        return false;
    }

}
