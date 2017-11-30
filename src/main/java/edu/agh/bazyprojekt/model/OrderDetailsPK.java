package edu.agh.bazyprojekt.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class OrderDetailsPK implements Serializable {
    private short orderId;
    private short productId;

    @Column(name = "orderid")
    @Id
    public short getOrderId() {
        return orderId;
    }

    public void setOrderId(short orderId) {
        this.orderId = orderId;
    }

    @Column(name = "productid")
    @Id
    public short getProductId() {
        return productId;
    }

    public void setProductId(short productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDetailsPK that = (OrderDetailsPK) o;

        if (orderId != that.orderId) return false;
        if (productId != that.productId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) orderId;
        result = 31 * result + (int) productId;
        return result;
    }
}
