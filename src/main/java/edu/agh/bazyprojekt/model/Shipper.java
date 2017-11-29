package edu.agh.bazyprojekt.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Shippers")
public class Shipper {
    @Id
    private int shipperID;
    private String companyName;
    private String phone;

    public int getShipperID() {
        return shipperID;
    }

    public void setShipperID(int shipperID) {
        this.shipperID = shipperID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
