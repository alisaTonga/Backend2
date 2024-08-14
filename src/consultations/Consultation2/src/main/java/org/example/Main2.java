package org.example;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<String> list = List.of("jack", "ann", "lena", "klaus");
        List<String> list1 = list.stream()
                .filter(e -> e.length() > 3)
                .toList();
        System.out.println(list1);
        System.out.println(list.stream()
                .filter(s->s.length()>3)
                .map(s -> s.toUpperCase())
                .toList());

        System.out.println(list.stream()
                .filter(s->s.length()>3)
                .map(s -> s.toUpperCase())
                .toList());
    }
}
