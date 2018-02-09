package edu.agh.bazyprojekt.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "customers", schema = "public", catalog = "northwind")
public class Customer {
    private String customerID;
    private String companyName;
    private String contactName;
    private String contactTitle;
    private String address;
    private String city;
    private String region;
    private String postalcode;
    private String country;
    private String phone;
    private String fax;
    private Collection<Order> orders;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerid")
    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerid) {
        this.customerID = customerid;
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
    @Column(name = "contactname")
    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactname) {
        this.contactName = contactname;
    }

    @Basic
    @Column(name = "contacttitle")
    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contacttitle) {
        this.contactTitle = contacttitle;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "region")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Basic
    @Column(name = "postalcode")
    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "fax")
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (customerID != null ? !customerID.equals(customer.customerID) : customer.customerID != null) return false;
        if (companyName != null ? !companyName.equals(customer.companyName) : customer.companyName != null)
            return false;
        if (contactName != null ? !contactName.equals(customer.contactName) : customer.contactName != null)
            return false;
        if (contactTitle != null ? !contactTitle.equals(customer.contactTitle) : customer.contactTitle != null)
            return false;
        if (address != null ? !address.equals(customer.address) : customer.address != null) return false;
        if (city != null ? !city.equals(customer.city) : customer.city != null) return false;
        if (region != null ? !region.equals(customer.region) : customer.region != null) return false;
        if (postalcode != null ? !postalcode.equals(customer.postalcode) : customer.postalcode != null) return false;
        if (country != null ? !country.equals(customer.country) : customer.country != null) return false;
        if (phone != null ? !phone.equals(customer.phone) : customer.phone != null) return false;
        if (fax != null ? !fax.equals(customer.fax) : customer.fax != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerID != null ? customerID.hashCode() : 0;
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (contactName != null ? contactName.hashCode() : 0);
        result = 31 * result + (contactTitle != null ? contactTitle.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (postalcode != null ? postalcode.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        return result;
    }

    @JsonManagedReference(value="customer-order")
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    public Collection<Order> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Order> ordersByCustomerid) {
        this.orders = ordersByCustomerid;
    }
}
