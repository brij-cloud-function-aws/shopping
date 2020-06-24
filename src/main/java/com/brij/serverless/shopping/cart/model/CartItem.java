package com.brij.serverless.shopping.cart.model;

import com.brij.serverless.shopping.cart.entity.CartItemEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode
@Builder
public class CartItem {
    private UUID id;
    private String sku;
    private int qty;
    private double unitCost;
    private UUID cartId ;

    public CartItemEntity toEntity(){
        CartItemEntity entity = new CartItemEntity();
        entity.setId(this.getId());
        //TODO set the cart id
        // entity.setCart();
        entity.setQty(this.getQty());
        entity.setSku(this.getSku());
        entity.setUnitCost(this.getUnitCost());
        return entity;
    }

}
