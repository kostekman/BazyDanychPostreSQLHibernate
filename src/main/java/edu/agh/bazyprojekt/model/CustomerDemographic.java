package edu.agh.bazyprojekt.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CustomerDemographics")
public class CustomerDemographic {
    @Id
    private int customerTypeID;
    private String CustomerDesc;

    public int getCustomerTypeID() {
        return customerTypeID;
    }

    public void setCustomerTypeID(int customerTypeID) {
        this.customerTypeID = customerTypeID;
    }

    public String getCustomerDesc() {
        return CustomerDesc;
    }

    public void setCustomerDesc(String customerDesc) {
        CustomerDesc = customerDesc;
    }
}
