package edu.agh.bazyprojekt.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.xml.bind.ValidationEventLocator;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "categories", schema = "public", catalog = "northwind")
public class Category {
    private short categoryID;
    private String categoryName;
    private String description;
    private byte[] picture;
    private Collection<Product> productsInCategory;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryid")
    public short getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(short categoryid) {
        this.categoryID = categoryid;
    }

    @Basic
    @Column(name = "categoryname")
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryname) {
        this.categoryName = categoryname;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "picture")
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
    public Collection<Product> getProductsInCategory() {
        return productsInCategory;
    }

    public void setProductsInCategory(Collection<Product> productsByCategoryid) {
        this.productsInCategory = productsByCategoryid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (categoryID != category.categoryID) return false;
        if (categoryName != null ? !categoryName.equals(category.categoryName) : category.categoryName != null)
            return false;
        if (description != null ? !description.equals(category.description) : category.description != null)
            return false;
        if (!Arrays.equals(picture, category.picture)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) categoryID;
        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(picture);
        return result;
    }


}
