package com.company;

import java.util.HashMap;
import java.util.Map;

public class LRU {

    public class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }

    Node head = new Node();
    Node tail = new Node();
    Map<Integer, Node> mymap;
    int cache_capacity ;

    public LRU(int capacity) {
        mymap = new HashMap<>(capacity);
        this.cache_capacity = capacity;
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        int result = -1;
        Node node = mymap.get(key);
        if (node != null) {
            result = node.value;
            remove(node);
            add(node);
        }
        return result;
    }

    public void set(int key, int value) {
        Node node = mymap.get(key);
        if (node != null) {
            remove(node);
            node.value = value;
            add(node);
        } else {
            if (mymap.size() == cache_capacity) {
                mymap.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node new_node = new Node();
            new_node.key = key;
            new_node.value = value;

            mymap.put(key, new_node);
            add(new_node);
        }
    }

    public void remove(Node node) {
        Node next_node = node.next;
        Node prev_node = node.prev;

        prev_node.next = next_node;
        next_node.prev = prev_node;
    }

    public void add(Node node) {
        //Node head_next=head.next;
        node.next = head.next;
        head.next.prev = node;

        head.next = node;
        node.prev = head;
    }
}
