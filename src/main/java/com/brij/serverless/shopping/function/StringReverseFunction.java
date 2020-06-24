package com.brij.serverless.shopping.function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

public class StringReverseFunction implements Function<String, String> {

    @Override
    public String apply(String d) {
       return new StringBuilder(d).reverse().toString();
    }
}