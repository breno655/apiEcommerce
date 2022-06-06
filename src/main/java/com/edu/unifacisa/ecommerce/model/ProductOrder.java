package com.edu.unifacisa.ecommerce.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_product_order")
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int quantity;

    @ManyToOne
    private Order order;
    @ManyToOne
    private Product product;

    public ProductOrder(Order order, Product product) {
        this.order = order;
        this.product = product;
    }

    public ProductOrder() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

