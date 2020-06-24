package com.brij.serverless.shopping.cart.service;

import com.brij.serverless.shopping.cart.entity.CartEntity;
import com.brij.serverless.shopping.cart.entity.CartItemEntity;
import com.brij.serverless.shopping.cart.repository.CartRepository;
import com.google.common.collect.ImmutableSet;
import jdk.nashorn.internal.ir.annotations.Immutable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
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
    public Optional<CartEntity> getCart(Integer customerId){
        return cartRepository.findByCustomerId(customerId);

    }
    public Optional<CartEntity> addToCart(Integer customerId, CartItemEntity item){
        return cartRepository.findByCustomerId(customerId).map(c ->{
            item.setId(UUID.randomUUID());
            item.setCart(c);
            c.getItems().add(item);
            return c;
        });

    }
}
