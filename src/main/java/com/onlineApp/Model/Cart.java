package com.onlineApp.Model;

import com.onlineApp.Util.DateUtil;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "cart_id1")
    @SequenceGenerator(name = "cart_id1", initialValue = 6000, sequenceName = "cart_id_generator")
    @Column(name = "cart_id")
    private long id;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name="product_id")
    private Product product;

    @NotNull(message = "Quantity can not be empty")
    @Min(value = 1, message = "Minimum quantity should be 1")
    @Max(value = 20, message = "Maximum quantity should be 20")
    @Column(name = "quantity")
    private int qty;

    @Column(name = "time_added")
    private long timeAdded;

    public Cart() {
        this.timeAdded = DateUtil.getCurrentTimeInMillis();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public long getTimeAdded() {
        return timeAdded;
    }

    public void setTimeAdded(long timeAdded) {
        this.timeAdded = timeAdded;
    }
}
