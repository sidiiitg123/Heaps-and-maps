package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class KLargestNumber {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> output=new ArrayList<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(A);
        while(B!=0){
            output.add(pq.poll());
            B--;
        }
        return output;
    }
}
