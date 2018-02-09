package edu.agh.bazyprojekt.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order_details", schema = "public", catalog = "northwind")
@IdClass(OrderDetailsPK.class)
public class OrderDetails implements Serializable {
    private short orderId;
    private short productId;
    private float unitPrice;
    private short quantity;
    private float discount;
    private Order order;
    private Product product;

    @Id
    @Column(name = "orderid")
    public short getOrderId() {
        return orderId;
    }

    public void setOrderId(short orderid) {
        this.orderId = orderid;
    }

    @Id
    @Column(name = "productid")
    public short getProductId() {
        return productId;
    }

    public void setProductId(short productid) {
        this.productId = productid;
    }

    @Basic
    @Column(name = "unitprice")
    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitprice) {
        this.unitPrice = unitprice;
    }

    @Basic
    @Column(name = "quantity")
    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "discount")
    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDetails that = (OrderDetails) o;

        if (orderId != that.orderId) return false;
        if (productId != that.productId) return false;
        if (Float.compare(that.unitPrice, unitPrice) != 0) return false;
        if (quantity != that.quantity) return false;
        if (Float.compare(that.discount, discount) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) orderId;
        result = 31 * result + (int) productId;
        result = 31 * result + (unitPrice != +0.0f ? Float.floatToIntBits(unitPrice) : 0);
        result = 31 * result + (int) quantity;
        result = 31 * result + (discount != +0.0f ? Float.floatToIntBits(discount) : 0);
        return result;
    }

    @JsonBackReference(value="orderDetails-order")
    @ManyToOne
    @JoinColumn(name = "orderid", referencedColumnName = "orderid", nullable = false, insertable = false, updatable = false)
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order ordersByOrderid) {
        this.order = ordersByOrderid;
    }

    @JsonBackReference(value="orderDetails-product")
    @ManyToOne
    @JoinColumn(name = "productid", referencedColumnName = "productid", nullable = false, insertable = false, updatable = false)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product productsByProductid) {
        this.product = productsByProductid;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("ProductID: " + this.getProductId() + "\n");
        sb.append("Quantity: " + this.getQuantity() + "\n");
        sb.append("Price: " + this.getUnitPrice() * (1 - this.getDiscount()) + "\n");

        return sb.toString();
    }
}
