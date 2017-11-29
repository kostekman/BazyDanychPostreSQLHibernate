package edu.agh.bazyprojekt.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Categories")
public class Category {
    @Id
    private int categoryID;
    private String categoryName;
    private String description;

    @OneToMany
    @JoinTable(
            name = "Products",
            joinColumns = @JoinColumn(name = "categoryID")
    )
    private Set<Product> products;

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
