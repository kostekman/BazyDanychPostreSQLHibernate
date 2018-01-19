package edu.agh.bazyprojekt.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "employees")
public class Employee {
    private short employeeId;
    private String lastName;
    private String firstName;
    private String title;
    private String titleOfCourtesy;
    private Date birthDate;
    private Date hiredDate;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String homePhone;
    private String extension;
    private byte[] photo;
    private String notes;
    private String photoPath;
    private Employee reportsTo;
    private Collection<Employee> managedEmployees;
    private Collection<Order> managedOrders;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeid")
    public short getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(short employeeid) {
        this.employeeId = employeeid;
    }

    @Basic
    @Column(name = "lastname")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    @Basic
    @Column(name = "firstname")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "titleofcourtesy")
    public String getTitleOfCourtesy() {
        return titleOfCourtesy;
    }

    public void setTitleOfCourtesy(String titleofcourtesy) {
        this.titleOfCourtesy = titleofcourtesy;
    }

    @Basic
    @Column(name = "birthdate")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthdate) {
        this.birthDate = birthdate;
    }

    @Basic
    @Column(name = "hiredate")
    public Date getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(Date hiredate) {
        this.hiredDate = hiredate;
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
    @Column(name = "homephone")
    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homephone) {
        this.homePhone = homephone;
    }

    @Basic
    @Column(name = "extension")
    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Basic
    @Column(name = "photo")
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Basic
    @Column(name = "photopath")
    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photopath) {
        this.photoPath = photopath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (employeeId != employee.employeeId) return false;
        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (title != null ? !title.equals(employee.title) : employee.title != null) return false;
        if (titleOfCourtesy != null ? !titleOfCourtesy.equals(employee.titleOfCourtesy) : employee.titleOfCourtesy != null)
            return false;
        if (birthDate != null ? !birthDate.equals(employee.birthDate) : employee.birthDate != null) return false;
        if (hiredDate != null ? !hiredDate.equals(employee.hiredDate) : employee.hiredDate != null) return false;
        if (address != null ? !address.equals(employee.address) : employee.address != null) return false;
        if (city != null ? !city.equals(employee.city) : employee.city != null) return false;
        if (region != null ? !region.equals(employee.region) : employee.region != null) return false;
        if (postalCode != null ? !postalCode.equals(employee.postalCode) : employee.postalCode != null) return false;
        if (country != null ? !country.equals(employee.country) : employee.country != null) return false;
        if (homePhone != null ? !homePhone.equals(employee.homePhone) : employee.homePhone != null) return false;
        if (extension != null ? !extension.equals(employee.extension) : employee.extension != null) return false;
        if (!Arrays.equals(photo, employee.photo)) return false;
        if (notes != null ? !notes.equals(employee.notes) : employee.notes != null) return false;
        if (photoPath != null ? !photoPath.equals(employee.photoPath) : employee.photoPath != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) employeeId;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (titleOfCourtesy != null ? titleOfCourtesy.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (hiredDate != null ? hiredDate.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (homePhone != null ? homePhone.hashCode() : 0);
        result = 31 * result + (extension != null ? extension.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(photo);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (photoPath != null ? photoPath.hashCode() : 0);
        return result;
    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "reportsto", referencedColumnName = "employeeid")
    public Employee getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Employee employeesByReportsto) {
        this.reportsTo = employeesByReportsto;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "reportsTo", cascade = CascadeType.DETACH)
    public Collection<Employee> getManagedEmployees() {
        return managedEmployees;
    }

    public void setManagedEmployees(Collection<Employee> employeesByEmployeeid) {
        this.managedEmployees = employeesByEmployeeid;
    }

    @JsonBackReference
    @OneToMany(mappedBy = "employee")
    public Collection<Order> getManagedOrders() {
        return managedOrders;
    }

    public void setManagedOrders(Collection<Order> ordersByEmployeeid) {
        this.managedOrders = ordersByEmployeeid;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Name: " + firstName + " " + lastName + "\n");
        sb.append("Managed orders: \n");
        managedOrders.stream().forEach(order -> sb.append(order));

        return sb.toString();
    }
}
