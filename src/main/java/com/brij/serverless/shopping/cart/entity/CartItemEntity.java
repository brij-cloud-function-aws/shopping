package com.brij.serverless.shopping.cart.entity;

import com.brij.serverless.shopping.cart.model.Cart;
import com.brij.serverless.shopping.cart.model.CartItem;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Data
@Entity
@Table(name = "CART_ITEM")
public class CartItemEntity {

    @Id
    private UUID id;

    @Column
    private String sku;

    @Column
    private int qty;

    @Column(name="UNIT_COST")
    private double unitCost;

    @ManyToOne
    @JoinColumn(name="cartId", nullable=false)
    private CartEntity cart;

    public CartItem toDto(){
        return CartItem.builder()
        .unitCost(this.getUnitCost())
        .id(this.getId())
        .cartId(this.getCart().getCartId())
        .qty(this.getQty())
        .sku(this.getSku()).build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartItemEntity)) return false;
        CartItemEntity entity = (CartItemEntity) o;
        return getId() == entity.getId() &&
                getQty() == entity.getQty() &&
                Double.compare(entity.getUnitCost(), getUnitCost()) == 0 &&
                Objects.equals(getSku(), entity.getSku());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSku(), getQty(), getUnitCost());
    }

}
