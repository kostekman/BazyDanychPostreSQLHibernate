package edu.agh.bazyprojekt.model;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "orders", schema = "public", catalog = "northwind")
public class Order {
    private short orderId;
    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;
    private Float freight;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipRegion;
    private String shipPostalCode;
    private String shipCountry;
    @Cascade(value= org.hibernate.annotations.CascadeType.ALL)
    private Collection<OrderDetails> orderDetails;
    private Customer customer;
    private Employee employee;
    private Shipper shippedBy;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderid", updatable = false, nullable = false)
    public short getOrderId() {
        return orderId;
    }

    public void setOrderId(short orderid) {
        this.orderId = orderid;
    }

    @Basic
    @Column(name = "orderdate")
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderdate) {
        this.orderDate = orderdate;
    }

    @Basic
    @Column(name = "requireddate")
    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requireddate) {
        this.requiredDate = requireddate;
    }

    @Basic
    @Column(name = "shippeddate")
    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippeddate) {
        this.shippedDate = shippeddate;
    }

    @Basic
    @Column(name = "freight")
    public Float getFreight() {
        return freight;
    }

    public void setFreight(Float freight) {
        this.freight = freight;
    }

    @Basic
    @Column(name = "shipname")
    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipname) {
        this.shipName = shipname;
    }

    @Basic
    @Column(name = "shipaddress")
    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipaddress) {
        this.shipAddress = shipaddress;
    }

    @Basic
    @Column(name = "shipcity")
    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipcity) {
        this.shipCity = shipcity;
    }

    @Basic
    @Column(name = "shipregion")
    public String getShipRegion() {
        return shipRegion;
    }

    public void setShipRegion(String shipregion) {
        this.shipRegion = shipregion;
    }

    @Basic
    @Column(name = "shippostalcode")
    public String getShipPostalCode() {
        return shipPostalCode;
    }

    public void setShipPostalCode(String shippostalcode) {
        this.shipPostalCode = shippostalcode;
    }

    @Basic
    @Column(name = "shipcountry")
    public String getShipCountry() {
        return shipCountry;
    }

    public void setShipCountry(String shipcountry) {
        this.shipCountry = shipcountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderId != order.orderId) return false;
        if (orderDate != null ? !orderDate.equals(order.orderDate) : order.orderDate != null) return false;
        if (requiredDate != null ? !requiredDate.equals(order.requiredDate) : order.requiredDate != null) return false;
        if (shippedDate != null ? !shippedDate.equals(order.shippedDate) : order.shippedDate != null) return false;
        if (freight != null ? !freight.equals(order.freight) : order.freight != null) return false;
        if (shipName != null ? !shipName.equals(order.shipName) : order.shipName != null) return false;
        if (shipAddress != null ? !shipAddress.equals(order.shipAddress) : order.shipAddress != null) return false;
        if (shipCity != null ? !shipCity.equals(order.shipCity) : order.shipCity != null) return false;
        if (shipRegion != null ? !shipRegion.equals(order.shipRegion) : order.shipRegion != null) return false;
        if (shipPostalCode != null ? !shipPostalCode.equals(order.shipPostalCode) : order.shipPostalCode != null)
            return false;
        if (shipCountry != null ? !shipCountry.equals(order.shipCountry) : order.shipCountry != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) orderId;
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (requiredDate != null ? requiredDate.hashCode() : 0);
        result = 31 * result + (shippedDate != null ? shippedDate.hashCode() : 0);
        result = 31 * result + (freight != null ? freight.hashCode() : 0);
        result = 31 * result + (shipName != null ? shipName.hashCode() : 0);
        result = 31 * result + (shipAddress != null ? shipAddress.hashCode() : 0);
        result = 31 * result + (shipCity != null ? shipCity.hashCode() : 0);
        result = 31 * result + (shipRegion != null ? shipRegion.hashCode() : 0);
        result = 31 * result + (shipPostalCode != null ? shipPostalCode.hashCode() : 0);
        result = 31 * result + (shipCountry != null ? shipCountry.hashCode() : 0);
        return result;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = false)
    public Collection<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Collection<OrderDetails> orderDetailsByOrderid) {
        this.orderDetails = orderDetailsByOrderid;
    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "customerid", referencedColumnName = "customerid")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customersByCustomerid) {
        this.customer = customersByCustomerid;
    }

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "employeeid", referencedColumnName = "employeeid")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employeesByEmployeeid) {
        this.employee = employeesByEmployeeid;
    }

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "shipvia", referencedColumnName = "shipperid")
    public Shipper getShippedBy() {
        return shippedBy;
    }

    public void setShippedBy(Shipper shippersByShipvia) {
        this.shippedBy = shippersByShipvia;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Order id: "  + this.getOrderId() + "\n");
        sb.append("Client name: " + this.getCustomer().getContactName() + "\n");
        sb.append("Ordered products: " + "\n");
        this.getOrderDetails().stream().forEach(orderDetails -> sb.append(orderDetails));

        sb.append("\n");
        return sb.toString();
    }
}
