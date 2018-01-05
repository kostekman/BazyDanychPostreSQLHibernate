package edu.agh.bazyprojekt.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "suppliers", schema = "public", catalog = "northwind")
public class Supplier {
    private short supplierId;
    private String companyName;
    private String contactName;
    private String contactTitle;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String phone;
    private String fax;
    private String homepage;
    @Cascade(value = org.hibernate.annotations.CascadeType.PERSIST)
    private Collection<Product> products;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplierid")
    public short getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(short supplierid) {
        this.supplierId = supplierid;
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
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalcode) {
        this.postalCode = postalcode;
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

    @Basic
    @Column(name = "homepage")
    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Supplier supplier = (Supplier) o;

        if (supplierId != supplier.supplierId) return false;
        if (companyName != null ? !companyName.equals(supplier.companyName) : supplier.companyName != null)
            return false;
        if (contactName != null ? !contactName.equals(supplier.contactName) : supplier.contactName != null)
            return false;
        if (contactTitle != null ? !contactTitle.equals(supplier.contactTitle) : supplier.contactTitle != null)
            return false;
        if (address != null ? !address.equals(supplier.address) : supplier.address != null) return false;
        if (city != null ? !city.equals(supplier.city) : supplier.city != null) return false;
        if (region != null ? !region.equals(supplier.region) : supplier.region != null) return false;
        if (postalCode != null ? !postalCode.equals(supplier.postalCode) : supplier.postalCode != null) return false;
        if (country != null ? !country.equals(supplier.country) : supplier.country != null) return false;
        if (phone != null ? !phone.equals(supplier.phone) : supplier.phone != null) return false;
        if (fax != null ? !fax.equals(supplier.fax) : supplier.fax != null) return false;
        if (homepage != null ? !homepage.equals(supplier.homepage) : supplier.homepage != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) supplierId;
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (contactName != null ? contactName.hashCode() : 0);
        result = 31 * result + (contactTitle != null ? contactTitle.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        result = 31 * result + (homepage != null ? homepage.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "supplier")
    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> productsBySupplierid) {
        this.products = productsBySupplierid;
    }
}
