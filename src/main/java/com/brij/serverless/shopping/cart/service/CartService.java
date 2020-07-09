package com.brij.serverless.shopping.cart.service;

import com.brij.serverless.shopping.cart.entity.CartEntity;
import com.brij.serverless.shopping.cart.entity.CartItemEntity;
import com.brij.serverless.shopping.cart.repository.CartRepository;
import com.google.common.collect.ImmutableSet;
import jdk.nashorn.internal.ir.annotations.Immutable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Iterable<CartEntity> getAll(){
        return cartRepository.findAll();
    }
    public Set<CartEntity> getCart(Integer customerId){
        return cartRepository.findByCustomerId(customerId);
    }

    public CartEntity save(CartEntity cart){
        if(cart.getCartId() == null){
            cart.setCartId(UUID.randomUUID());
        }
        for (CartItemEntity item : cart.getItems()) {
            if(item.getId() == null){
                item.setId(UUID.randomUUID());
            }
            item.setCart(cart);
        }
        return cartRepository.save(cart);
    }
}
