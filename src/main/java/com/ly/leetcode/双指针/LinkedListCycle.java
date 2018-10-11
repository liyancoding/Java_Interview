package com.ly.leetcode.双指针;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 16:55 2018/8/21
 * @Modified By:
 */
public class LinkedListCycle {
    /**
     * Definition for singly-linked list.
     */
    class ListNode extends LinkedList<Integer>{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
      }
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != null && fast != null && fast.next != null) {
            if (slow == fast) {
                System.out.println("It is true!");
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("It is false!");
        return false;
    }

    public static void main(String[] args){

//        LinkedListCycle linkedListCycle = new LinkedListCycle();
//        ListNode ln1 = linkedListCycle.new ListNode(21);
////        ListNode ln2 = linkedListCycle.new ListNode(5);
////        ListNode ln3 = linkedListCycle.new ListNode(3);
////        ListNode ln4 = linkedListCycle.new ListNode(15);
////        ListNode ln5 = linkedListCycle.new ListNode(44);
////        ListNode ln6 = linkedListCycle.new ListNode(21);
////
////        ln1.next.val =21;
//
//        hasCycle(ln1);

    }
}

