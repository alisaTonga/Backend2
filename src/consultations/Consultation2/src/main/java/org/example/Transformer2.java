package org.example;

public class Transformer2 implements StringTransformer{

    @Override
    public String transform(String string) {
        return string.toUpperCase();
    }
}
