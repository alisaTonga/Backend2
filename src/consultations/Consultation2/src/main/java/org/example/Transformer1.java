package org.example;

public class Transformer1 implements StringTransformer{

    @Override
    public String transform(String string) {
        return "(" + string + ")";
    }
}
