package edu.agh.bazyprojekt.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    private String customerID;
    private String companyName;
    private String contactName;
    private String contactTitle;
    private Address address;
    private String phone;
    private String fax;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "CustomerCustomerDemo",
            joinColumns = @JoinColumn(name = "customerID"),
            inverseJoinColumns = @JoinColumn(name = "customerTypeID")
    )
    private Set<CustomerDemographic> customerDemographics;
    @OneToMany
    @JoinTable(
            name = "Orders",
            joinColumns = @JoinColumn(name = "customerID")
    )
    private Set<Order> orders;

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Set<CustomerDemographic> getCustomerDemographics() {
        return customerDemographics;
    }

    public void setCustomerDemographics(Set<CustomerDemographic> customerDemographics) {
        this.customerDemographics = customerDemographics;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
