package com.brij.serverless.shopping.cart.entity;

import com.brij.serverless.shopping.cart.model.Cart;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "SHOPPING_CART")
public class CartEntity {

    @Id
    @Column(name="CART_ID")
    private UUID cartId ;

    @Column(name="CUSTOMER_ID")
    private Integer customerId;

    @OneToMany(mappedBy="cart", cascade= CascadeType.ALL, fetch= FetchType.EAGER)
    private Set<CartItemEntity> items;


    public Cart toDto(){
        Cart dto =Cart.builder()
        .customerId(this.getCustomerId())
        .cartId(this.getCartId())
       .items(this.getItems().stream().map(CartItemEntity::toDto).collect(Collectors.toSet())).build();
        return dto;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartEntity)) return false;
        CartEntity that = (CartEntity) o;
        return Objects.equals(getCustomerId(), that.getCustomerId()) &&
                Objects.equals(getItems(), that.getItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerId(), getItems());
    }
}
