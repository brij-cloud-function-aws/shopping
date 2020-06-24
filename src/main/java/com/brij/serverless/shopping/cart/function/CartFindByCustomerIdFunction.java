package com.brij.serverless.shopping.cart.function;

import com.brij.serverless.shopping.cart.entity.CartEntity;
import com.brij.serverless.shopping.cart.model.Cart;
import com.brij.serverless.shopping.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

public class CartFindByCustomerIdFunction implements Function<Integer, Optional<Cart>> {

    @Autowired
    CartService cartService;

    @Override
    public Optional<Cart> apply(Integer customerId) {
        return cartService.getCart(customerId)
                .map(CartEntity::toDto);
    }


}
