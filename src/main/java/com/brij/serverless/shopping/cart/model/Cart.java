package com.brij.serverless.shopping.cart.model;

import com.brij.serverless.shopping.cart.entity.CartEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@EqualsAndHashCode
@Builder
public class Cart {
    private UUID cartId ;
    private Integer customerId;
    private Set<CartItem> items;

    public CartEntity toEntity(){
        CartEntity entity = new CartEntity();
        entity.setCartId(this.getCartId());
        entity.setCustomerId(this.getCustomerId());
        entity.setItems(this.getItems().stream().map(CartItem::toEntity).collect(Collectors.toSet()));
        return entity;
    }
}
