package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MagicianAndChocolate {
    public static int nchoc(int A, ArrayList<Integer> B) {
        final int MOD = 1000000007;
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());

        for (Integer choc : B) {
            pq.add(choc);
        }

        long total = 0;

        while (A-- > 0) {
            int choc = pq.poll();
            total += choc;
            total %= MOD;
            pq.add(choc/2);
        }

        return (int) total;
    }
}
