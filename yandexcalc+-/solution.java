package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class solution {
    public static void main(String[] args) {
        String content;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            content = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        content = content.replaceAll(" ","");
        List<String> exp = new ArrayList<>();
        boolean numberstarts = false;
        int tmpdiv = 0;
        //часть 1 - помещаем каждый знак и полное число в лист стрингов
        for (int j=0;j<content.length();j++) {
            if ( content.charAt(j)== '-' || content.charAt(j)=='(' || content.charAt(j)==')' || content.charAt(j)=='+') {
                if (!numberstarts) {
                    exp.add(String.valueOf(content.charAt(j)));
                } else {
                    exp.add(content.substring(tmpdiv,j));
                    exp.add(String.valueOf(content.charAt(j)));
                    numberstarts = false;
                }
            } else {
                if (!numberstarts) {
                    tmpdiv = j;
                    numberstarts = true;
                }
            }
        }
        if (numberstarts) {
            exp.add(content.substring(tmpdiv));
        }
        //часть 2 - начинаем рекурсивно вычислять значение выражения, раскрывая внутренние скобки и записывая вместо них результат
        //ищем (, запоминаем положение и идем дальше, если снова (, то запоминаем её положение, а если ) - вычисляем результат в ()
        while(exp.contains("(")) {
            calcwithbrackets(exp);
        }
        System.out.println(calcwithoutbrackets(exp));
    }
    public static void calcwithbrackets(List<String> exp) {
        int bracketstart = 0;
        int bracketend = 0;
        int i;
        int res;
        for (i=0;i< exp.size();i++) {
            if (Objects.equals(exp.get(i), "(")) {
                bracketstart = i;
            }
        }
        for (int j=bracketstart;j< exp.size();j++) {
            if (Objects.equals(exp.get(j), ")")) {
                bracketend = j;
                break;
            }
        }
        //получили откуда докуда внутренние скобки
        res = calcwithoutbrackets(exp.subList(bracketstart+1,bracketend));
        //снова ищем позиции скобок, так как функция сократила нам цифры внутри
        for (i=0;i<exp.size();i++) {
            if (Objects.equals(exp.get(i), "(")) {
                bracketstart = i;
            }
        }
        for (int j=bracketstart;j<exp.size();j++) {
            if (Objects.equals(exp.get(j), ")")) {
                bracketend = j;
                break;
            }
        }
        exp.set(bracketstart,String.valueOf(res));
        exp.subList(bracketstart+1,bracketend+1).clear();
    }
    public static int calcwithoutbrackets(List<String> exp) {
        Integer tmp;
        for (int i=0;i<exp.size();i++) {
            //сначала решаем со всеми минусами
            if (Objects.equals(exp.get(i), "-")) {
                tmp = Integer.parseInt(exp.get(i+1));
                tmp = tmp*(-1);
                exp.set(i+1,String.valueOf(tmp));
                exp.remove(i);
                //i--;
            }
            if (Objects.equals(exp.get(i), "+")) {
                exp.remove(i);
                i--;
            }
        }
        tmp = 0;
        //осталось сложить все слагаемые
        for (String a:exp) {
            tmp = tmp + Integer.parseInt(a);
        }
        return tmp;
    }
}
