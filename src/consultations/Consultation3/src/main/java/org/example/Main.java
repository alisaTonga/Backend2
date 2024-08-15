package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        List<String> list = new LinkedList<>();
//        for (int i = 0; i < list.size(); i++) {
//            String element = list.get(i);
//        }
        //for each  i=1 , 1 = i=2 , i=1+1, 2 i=1+1+1+ 3...
        //starts with 1

//
//        list = new LinkedList<>();
//        for (String string: list) {
//        }
        // for doesn't start from the start
        // stream :
        //map 1-1 element
        // flat map 1-many
        // 1. we use copy, we cannot change original info
        // 2. multiple stream, simultaneously action
        List<String> list =List.of(
                "jack","ann","wahab","nikolaus","alisa","rica","lena","wahab"
        );
        Optional<String> s = list.stream().findAny(); // return null or String
        //distinct - delete repeated elements *use carefully*
                // final operators don't return stream
                //
        list.stream().collect(Collectors.toList());
        Set<String> set = list.stream().collect(Collectors.toSet());
        Set<String> set1 = list.stream().collect(Collectors.toCollection(()-> new TreeSet<>()));
        list.stream().collect(Collectors.toList());
                // reduce - make 1 element from stream. The best use to count total amount
                //reduce is a variant of collect
                // reduce is a function it needs: current element and accumulate(e, s)-> s+e
                // Collect - one collection or one amount
                // the most used collector is- to list()
        Map<String, Integer> collected = list.stream().collect(Collectors.toMap(s1 -> s1, s1 -> s1.length(), (v1, v2)-> v1+v2));
        Map<Integer, String> collected1 = list.stream().collect(Collectors.toMap(s2 -> s2.length(), s2 -> s2, (v1, v2)-> v1+ "|" + v2));

        //v1 1 el,
        //v2 second element
        // 1 function - how to get key from string
        //2function - how to get value#
        // 3 what to do if i have repeated elements
        System.out.println(collected);
        System.out.println(collected1);
        System.out.println(list.stream().collect(Collectors.joining("-", "<", ">")));





    }
}