package com.onlineApp.Model;

import javax.persistence.*;

@Entity
public class QuantityProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "productQ_id")
    @SequenceGenerator(name = "productQ_id", initialValue = 7000, sequenceName = "productQ_id_generator")
    private long id;
    @OneToOne
    private Product products;

    @Column(name = "total_Product_Price")
    private double priceWithQuantityTotal;

    @Column(name = "quantity")
    private int quantity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }

    public double getPriceWithQuantityTotal() {
        return priceWithQuantityTotal;
    }

    public void setPriceWithQuantityTotal(double priceWithQuantityTotal) {
        this.priceWithQuantityTotal = priceWithQuantityTotal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
