package com.zosh.repository;

import com.zosh.model.Cart;
import com.zosh.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
