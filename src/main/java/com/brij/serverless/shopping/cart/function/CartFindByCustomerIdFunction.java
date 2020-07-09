package com.brij.serverless.shopping.cart.function;

import com.brij.serverless.shopping.cart.entity.CartEntity;
import com.brij.serverless.shopping.cart.model.Cart;
import com.brij.serverless.shopping.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CartFindByCustomerIdFunction implements Function<Integer, Set<Cart>> {

    private CartService cartService;
    @Autowired
    public CartFindByCustomerIdFunction( CartService cartService){
        this.cartService=cartService;
    }

    @Override
    public Set<Cart> apply(Integer customerId) {
        return cartService.getCart(customerId).stream()
                .map(CartEntity::toDto).collect(Collectors.toSet());
    }


}
