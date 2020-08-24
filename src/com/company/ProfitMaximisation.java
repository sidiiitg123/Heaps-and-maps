package com.company;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ProfitMaximisation {
    public int solve(ArrayList<Integer> A, int B) {
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.addAll(A);
        while (B != 0) {
            int num = pq.peek();
            pq.poll();
            ans += num;
            if (num > 1) {
                pq.add(num - 1);
            }
            B--;
        }
        return ans;
    }
//    Proper heapify without using java priority queue
    //array implementation of max heap here

//    public void heapify(ArrayList<Integer> A, int idx) {
//        int largest = idx;
//        int l = 2*idx + 1;
//        int r = 2*idx + 2;
//        if(l < A.size() && A.get(l) > A.get(largest))  {
//            largest = l;
//        }
//        if(r < A.size() && A.get(r) > A.get(largest))  {
//            largest = r;
//        }
//        if(largest != idx) {
//            int temp = A.get(largest);
//            A.set(largest, A.get(idx));
//            A.set(idx, temp);
//            heapify(A, largest);
//        }
//    }
//    public int solve(ArrayList<Integer> A, int B) {
//        for(int i=A.size()/2-1; i>=0; i--) {
//            heapify(A, i);
//        }
//        int profit = 0;
//        for(int i=0; i<B; i++) {
//            profit = profit + A.get(0);
//            A.set(0, A.get(0)-1);
//            heapify(A, 0);
//        }
//        return profit;
//    }
}
