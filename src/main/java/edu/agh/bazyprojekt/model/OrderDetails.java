package edu.agh.bazyprojekt.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "Order_Details")
public class OrderDetails {
    @Id
    @ManyToOne
    @JoinColumn(name = "OrderID")
    private Order order;
    @Id
    @ManyToOne
    @JoinColumn(name = "ProductID")
    private Product product;

    private double unitPrice;
    private int quantity;
    private double discount;
}
