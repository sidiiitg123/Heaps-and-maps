package com.company;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArray {
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> output = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ArrayList<Integer> a : A) {
            pq.addAll(a);
        }
        while (pq.size() != 0)
            output.add(pq.poll());
        return output;
    }
}
