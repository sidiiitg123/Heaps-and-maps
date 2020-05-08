package com.company;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestConsecutiveSeq {

    public int longestConsecutive(final List<Integer> A) {

        if(A.size()==0){
            return 0;
        }
        if(A.size()==1){
            return 1;
        }
        Set<Integer> myset= new HashSet<>();

       for(int i=0;i<A.size();i++){
           if(!myset.contains(A.get(i))){
               myset.add(A.get(i));
           }
       }
       int max=1;
       for(int i:myset){
           if(!myset.contains(i-1)){
               int current =i;
               int newmax=1;
               while(myset.contains(current+1)){
                   newmax+=1;
                   current+=1;
               }
               max=Math.max(max,newmax);
           }
       }
       return max;
    }
}
