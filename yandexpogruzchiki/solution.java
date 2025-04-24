package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class solution {
    public static void main(String[] args) {
        int total;
        String[] way;
        int tempres =0;
        boolean shrinked = false;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String content = reader.readLine();
            total = Integer.parseInt(content);
            content = reader.readLine();
            way = content.split(" ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Integer> answers = new ArrayList<>();
        ArrayList<String> combo = new ArrayList<>();
        for (int i = 0;i<total;i++) {
                combo.add(way[i]);
                if(combo.size()>=2) {
                    if (Objects.equals(combo.getLast(), combo.get(combo.size() - 2))) {
                        tempres=tempres+2;
                        combo.removeLast();
                        combo.removeLast();
                        shrinked = true;
                        continue;
                    }
                }
                if(combo.size()>=3) {
                    if (Objects.equals(combo.getLast(), combo.get(combo.size()-3))) {
                        tempres = tempres + 3;
                        combo.removeLast();
                        combo.removeLast();
                        combo.removeLast();
                        shrinked = true;
                        continue;
                    }
                }
                if (shrinked) {
                    answers.add(tempres);
                    tempres = 0;
                    combo.clear();
                    shrinked = false;
                }
        }
        int max = tempres;
        for (Integer answer : answers) {
            max = Math.max(max, answer);
        }
        System.out.println(max);

    }
}
