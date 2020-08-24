package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumSumCombination {
    class Triplet
    {
        int x, y, sum;
        Triplet(int x, int y, int sum)
        {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        Collections.sort(A,(x,y)->y-x);
        Collections.sort(B,(x,y)->y-x);
        PriorityQueue<Triplet> maxHeap = new PriorityQueue<>((a,b) -> b.sum - a.sum);

        for(int i = 0; i < A.size(); i++)
            maxHeap.add(new Triplet(i, 0, A.get(i) + B.get(0)));
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < C; i++)
        {
            Triplet t = maxHeap.poll();

            ans.add(t.sum);

            if(t.y == B.size() - 1)
                continue;

            maxHeap.add(new Triplet(t.x, t.y + 1, A.get(t.x) + B.get(t.y + 1)));
        }
        return ans;
    }
}
