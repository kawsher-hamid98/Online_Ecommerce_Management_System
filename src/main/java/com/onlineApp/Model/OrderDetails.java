package com.onlineApp.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "order_id1")
    @SequenceGenerator(name = "order_id1", initialValue = 5000, sequenceName = "order_id_generator")
    @Column(name = "order_id")
    private long id;

    @Column(name = "order_total_price")
    private double totalPrice;

    @ManyToOne
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL)
    private List<QuantityProduct> productWithQuantity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<QuantityProduct> getProductWithQuantity() {
        return productWithQuantity;
    }

    public void setProductWithQuantity(List<QuantityProduct> productWithQuantity) {
        this.productWithQuantity = productWithQuantity;
    }
}
