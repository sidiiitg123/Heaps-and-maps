package com.company;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKlinkedList {
    class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        ListNode head = null;
        ListNode last = null;

        PriorityQueue<ListNode> p = new PriorityQueue<>((x, y) -> x.val - y.val);
        for(ListNode t: a){
            if(t!=null){
                p.offer(t);
            }
        }
        while(p.size()>0){
            ListNode t = p.poll();

            if(t.next!=null){
                p.offer(t.next);
            }

            if(head == null){
                head = t;
                last = t;
            }
            else{
                last.next = t;
                last = last.next;
            }
        }
        last.next = null;
      return head;
    }
}
