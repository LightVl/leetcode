package org.example;

import org.apache.commons.math3.util.Combinations;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n=5;
        int k=3;
        Combinations c = new Combinations(n,k);
        List<List<Integer>> al = new ArrayList<List<Integer>>();
        for(int[] iterate : c){
            for (int i=0;i<iterate.length;i++) {
                iterate[i]=iterate[i]+1;
            }
            List<Integer> integerList = Arrays.stream(iterate)
                    .boxed()
                    .toList();
            al.add(integerList);
            System.out.println(Arrays.toString(integerList.toArray()));
        }
    }
}
