package edu.agh.bazyprojekt.model;

import javax.persistence.*;

@Entity
@Table(name = "customerdemographics", schema = "public", catalog = "northwind")
public class CustomerDemo {
    private String customerTypeId;
    private String customerDesc;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customertypeid")
    public String getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(String customertypeid) {
        this.customerTypeId = customertypeid;
    }

    @Basic
    @Column(name = "customerdesc")
    public String getCustomerDesc() {
        return customerDesc;
    }

    public void setCustomerDesc(String customerdesc) {
        this.customerDesc = customerdesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerDemo that = (CustomerDemo) o;

        if (customerTypeId != null ? !customerTypeId.equals(that.customerTypeId) : that.customerTypeId != null)
            return false;
        if (customerDesc != null ? !customerDesc.equals(that.customerDesc) : that.customerDesc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerTypeId != null ? customerTypeId.hashCode() : 0;
        result = 31 * result + (customerDesc != null ? customerDesc.hashCode() : 0);
        return result;
    }
}
