package com.brij.serverless.shopping.cart.function;

import com.brij.serverless.shopping.cart.model.Cart;

import java.util.function.Function;

public class CartAddUpdateFunction implements Function<Cart, Cart> {

    @Override
    public Cart apply(Cart d) {
        return d;
    }
}
