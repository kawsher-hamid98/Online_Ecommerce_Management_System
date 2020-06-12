package com.onlineApp.Model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "product_id")
    @SequenceGenerator(name = "product_id", initialValue = 3000, sequenceName = "product_id_generator")
    private long productId;

    @NotNull(message= "Product name can not be empty")
    @Column(name = "product_name")
    @Size(min = 2, max = 30, message = "Product name must be between 2 to 30 characters")
    private String productName;

    @NotNull(message= "Product category can not be empty")
    @Column(name = "product_category")
    @Size(min = 3, max = 30, message = "Product category must be between 3 to 30 characters")
    private String productCategory;

    @NotNull(message= "Product Price can not be empty")
    @Column(name = "product_price")
    @Min(value = 1, message = "Price must be equal or greater than 1")
    @Max(value = 1000, message = "Price must be equal or less than 1000")
    private Double productPrice;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }
}
