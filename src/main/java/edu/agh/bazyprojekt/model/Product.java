package edu.agh.bazyprojekt.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "products", schema = "public", catalog = "northwind")
public class Product {
    private short productId;
    private String productName;
    private String quantityPerUnit;
    private Float unitPrice;
    private Short unitsInStock;
    private Short unitsOnOrder;
    private Short reorderLevel;
    private int discontinued;
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Collection<OrderDetails> orderDetails;
    private Supplier supplier;
    private Category category;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    public short getProductId() {
        return productId;
    }

    public void setProductId(short productid) {
        this.productId = productid;
    }

    @Basic
    @Column(name = "productname")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productname) {
        this.productName = productname;
    }

    @Basic
    @Column(name = "quantityperunit")
    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityperunit) {
        this.quantityPerUnit = quantityperunit;
    }

    @Basic
    @Column(name = "unitprice")
    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitprice) {
        this.unitPrice = unitprice;
    }

    @Basic
    @Column(name = "unitsinstock")
    public Short getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(Short unitsinstock) {
        this.unitsInStock = unitsinstock;
    }

    @Basic
    @Column(name = "unitsonorder")
    public Short getUnitsOnOrder() {
        return unitsOnOrder;
    }

    public void setUnitsOnOrder(Short unitsonorder) {
        this.unitsOnOrder = unitsonorder;
    }

    @Basic
    @Column(name = "reorderlevel")
    public Short getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(Short reorderlevel) {
        this.reorderLevel = reorderlevel;
    }

    @Basic
    @Column(name = "discontinued")
    public int getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(int discontinued) {
        this.discontinued = discontinued;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (productId != product.productId) return false;
        if (discontinued != product.discontinued) return false;
        if (productName != null ? !productName.equals(product.productName) : product.productName != null) return false;
        if (quantityPerUnit != null ? !quantityPerUnit.equals(product.quantityPerUnit) : product.quantityPerUnit != null)
            return false;
        if (unitPrice != null ? !unitPrice.equals(product.unitPrice) : product.unitPrice != null) return false;
        if (unitsInStock != null ? !unitsInStock.equals(product.unitsInStock) : product.unitsInStock != null)
            return false;
        if (unitsOnOrder != null ? !unitsOnOrder.equals(product.unitsOnOrder) : product.unitsOnOrder != null)
            return false;
        if (reorderLevel != null ? !reorderLevel.equals(product.reorderLevel) : product.reorderLevel != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) productId;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (quantityPerUnit != null ? quantityPerUnit.hashCode() : 0);
        result = 31 * result + (unitPrice != null ? unitPrice.hashCode() : 0);
        result = 31 * result + (unitsInStock != null ? unitsInStock.hashCode() : 0);
        result = 31 * result + (unitsOnOrder != null ? unitsOnOrder.hashCode() : 0);
        result = 31 * result + (reorderLevel != null ? reorderLevel.hashCode() : 0);
        result = 31 * result + discontinued;
        return result;
    }

    @OneToMany(mappedBy = "product")
    public Collection<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Collection<OrderDetails> orderDetailsByProductid) {
        this.orderDetails = orderDetailsByProductid;
    }

    @ManyToOne
    @JoinColumn(name = "supplierid", referencedColumnName = "supplierid")
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier suppliersBySupplierid) {
        this.supplier = suppliersBySupplierid;
    }

    @ManyToOne
    @JoinColumn(name = "categoryid", referencedColumnName = "categoryid")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category categoriesByCategoryid) {
        this.category = categoriesByCategoryid;
    }
}
