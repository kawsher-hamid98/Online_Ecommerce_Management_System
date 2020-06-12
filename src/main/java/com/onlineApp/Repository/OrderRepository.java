package com.onlineApp.Repository;

import com.onlineApp.Model.OrderDetails;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<OrderDetails, Long> {

    List<OrderDetails> findAllOrdersByCustomerId(long customer_id);
}
