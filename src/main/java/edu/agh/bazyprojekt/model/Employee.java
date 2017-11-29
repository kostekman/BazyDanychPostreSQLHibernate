package edu.agh.bazyprojekt.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "Employees")
public class Employee {
    @Id
    private int employeeID;
    private String lastName;
    private String firstName;
    private String title;
    private String titleOfCourtesy;
    private Date birthDate;
    private Date hireDate;
    private Address address;
    private String homePhone;
    private String extension;
    private String notes;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="reportsTo")
    private Employee manager;

    @OneToMany
    @JoinColumn(name = "reportsTo")
    private Set<Employee> managedEmployees;

    @OneToMany
    @JoinTable(
            name = "Orders",
            joinColumns = @JoinColumn(name = "EmployeeID")
    )
    private Set<Order> orders;

    @OneToMany
    @JoinTable(
            name = "EmployeeTerritories",
            joinColumns = @JoinColumn(name = "EmployeeID"),
            inverseJoinColumns = @JoinColumn(name = "TerritoryID")
    )
    private Set<Territory> territories;

    private String photoPath;

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleOfCourtesy() {
        return titleOfCourtesy;
    }

    public void setTitleOfCourtesy(String titleOfCourtesy) {
        this.titleOfCourtesy = titleOfCourtesy;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Set<Employee> getManagedEmployees() {
        return managedEmployees;
    }

    public void setManagedEmployees(Set<Employee> managedEmployees) {
        this.managedEmployees = managedEmployees;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<Territory> getTerritories() {
        return territories;
    }

    public void setTerritories(Set<Territory> territories) {
        this.territories = territories;
    }
}
