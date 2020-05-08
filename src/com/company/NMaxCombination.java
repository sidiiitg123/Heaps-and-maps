package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class NMaxCombination {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {

        Collections.sort(A,Collections.reverseOrder());//Array->Maxheap->heapsort->gives array in decreasing order
        Collections.sort(B,Collections.reverseOrder());//max heap

        PriorityQueue<Integer> pq=new PriorityQueue<>((x,y)->x-y);//equivalent to Collections.reverseOrder(decreasing list)

        for(Integer a:A){
            for(Integer b:B){
                int sum=a+b;
                if(pq.size()<A.size()){
                    pq.offer(sum);
                }else{
                    if(sum>pq.peek()){
                        pq.poll();
                        pq.offer(sum);
                    }else{
                        break;
                    }
                }
            }
        }
        ArrayList<Integer> output =new ArrayList<>(pq);
        Collections.sort(output,Collections.reverseOrder());
        return output;
    }
}
