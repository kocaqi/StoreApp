
package com.localweb.thelogin.thelogin.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@IdClass(OrderProductKey.class)
@Table(name="order_product")
public class OrderProduct {
    @ManyToOne
    @Id
    @JoinColumn(name="order_id")
    Order order;

    @ManyToOne(cascade = CascadeType.ALL)
    @Id
    @JoinColumn(name="product_id")
    Product product;

    @Column(name = "quantity")
    double quantity;
    @Column(name = "amount")
    double amount;
    @Column(name = "date_created")
    LocalDate dateCreated;
    @Column(name = "date_updated")
    LocalDate dateUpdated;

    public OrderProduct() {
    }

    public OrderProduct(Order order, Product product, double quantity, double amount, LocalDate dateCreated, LocalDate dateUpdated) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.amount = amount;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
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

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDate dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                ", order=" + order +
                ", product=" + product +
                ", quantity=" + quantity +
                ", amount=" + amount +
                ", dateCreated=" + dateCreated +
                ", dateUpdated=" + dateUpdated +
                '}';
    }
}

