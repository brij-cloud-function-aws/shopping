package com.brij.serverless.shopping.cart.repository;

import com.brij.serverless.shopping.cart.entity.CartEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface CartRepository extends CrudRepository<CartEntity, UUID> {
    Set<CartEntity> findByCustomerId(Integer customerId);
}
