package com.onlineApp.Repository;

import com.onlineApp.Model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findByProductName(String productName);
}
