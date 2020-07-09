package com.brij.serverless.shopping.cart.function;

import com.brij.serverless.shopping.cart.model.Cart;
import com.brij.serverless.shopping.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Function;

public class CartAddUpdateFunction implements Function<Cart, Cart> {

    private CartService cartService;
    @Autowired
    public CartAddUpdateFunction( CartService cartService){
        this.cartService=cartService;
    }
    @Override
    public Cart apply(Cart d) {
        return cartService.save(d.toEntity()).toDto();
    }
}
