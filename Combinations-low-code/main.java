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
        List<int[]> al = new ArrayList<int[]>();
        for(int[] iterate : c){
            for (int i=0;i<iterate.length;i++) {
                iterate[i]=iterate[i]+1;
            }
            al.add(iterate);
            System.out.println(Arrays.toString(iterate));
        }
    }
}
