package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        // if we want to use function we can use shorter version
        // only if the list elements type is the same then we can write (String::toUpperCase())


    }
    public static List<String> listHandler (List<String> list, Function<String, String> func){
        List<String > result = new ArrayList<>();
                for(String str: list){
                    result.add(func.apply(str));
                }
                return result;
    }
}