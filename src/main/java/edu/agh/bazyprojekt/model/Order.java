package edu.agh.bazyprojekt.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity(name = "Orders")
public class Order {
    @Id
    private int orderID;
    @ManyToOne
    @JoinTable(
            name = "Customers",
            joinColumns = @JoinColumn(name = "CustomerID")
    )
    private Customer customer;
    @ManyToOne
    @JoinTable(
            name = "Employees",
            joinColumns = @JoinColumn(name = "EmployeeID")
    )
    private Employee employee;
    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;
    @ManyToOne
    @JoinTable(
            name = "Shippers",
            joinColumns = @JoinColumn(name = "ShipperID")
    )
    private Shipper shippedVia;
    private double freight;
    private String shipName;
    private Address address;
    @OneToMany
    @JoinColumn(name = "OrderID")
    private Set<OrderDetails> orderDetails;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public Shipper getShippedVia() {
        return shippedVia;
    }

    public void setShippedVia(Shipper shippedVia) {
        this.shippedVia = shippedVia;
    }

    public double getFreight() {
        return freight;
    }

    public void setFreight(double freight) {
        this.freight = freight;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
