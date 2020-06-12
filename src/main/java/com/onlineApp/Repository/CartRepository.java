package com.onlineApp.Repository;

import com.onlineApp.Model.Cart;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface CartRepository extends CrudRepository<Cart, Long> {

    @Query("select cart from Cart cart where cart.customer.id = ?1 and cart.product.productId = ?2")
    Cart findCartByCustomerIdAndProductId(long customer_id, long product_id);

    @Query("select cart from Cart cart where cart.customer.id = ?1")
    List<Cart> findAllCartByCustomerId(long customer_id);

    @Transactional
    @Modifying
    @Query("delete from Cart cart where cart.customer.id = ?1")
    void deleteAllCartByCustomerId(long customer_id);
}
