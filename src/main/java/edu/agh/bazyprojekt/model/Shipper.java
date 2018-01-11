package edu.agh.bazyprojekt.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "shippers", schema = "public", catalog = "northwind")
public class Shipper {
    private short shipperId;
    private String companyName;
    private String phone;
    private Collection<Order> orders;

    @Id
    @GeneratedValue
    @Column(name = "shipperid")
    public short getShipperId() {
        return shipperId;
    }

    public void setShipperId(short shipperid) {
        this.shipperId = shipperid;
    }

    @Basic
    @Column(name = "companyname")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyname) {
        this.companyName = companyname;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shipper shipper = (Shipper) o;

        if (shipperId != shipper.shipperId) return false;
        if (companyName != null ? !companyName.equals(shipper.companyName) : shipper.companyName != null) return false;
        if (phone != null ? !phone.equals(shipper.phone) : shipper.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) shipperId;
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

    @JsonBackReference
    @OneToMany(mappedBy = "shippedBy")
    public Collection<Order> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Order> ordersByShipperid) {
        this.orders = ordersByShipperid;
    }
}
