package edu.uw.data.lecture8.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by credmond on 26/03/15.
 */
@Entity
@Table(name = "OFFICES")
public class Office {
  private String officeCode;
  private String city;
  private String phone;
  private String addressLine1;
  private String addressLine2;
  private String state;
  private String country;
  private String postalCode;
  private String territory;

  private Set<Employee> employees =new HashSet<>();

  @Id
  @Column(name = "OFFICE_CODE",  length = 10, nullable = false, insertable = true, updatable = true)
  public String getOfficeCode() {
    return officeCode;
  }

  public void setOfficeCode(String officeCode) {
    this.officeCode = officeCode;
  }

  @Basic
  @Column(name = "CITY", nullable = true, insertable = true, updatable = true, length = 50)
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  @Basic
  @Column(name = "PHONE", nullable = true, insertable = true, updatable = true, length = 50)
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Basic
  @Column(name = "ADDRESS_LINE1", nullable = true, insertable = true, updatable = true, length = 50)
  public String getAddressLine1() {
    return addressLine1;
  }

  public void setAddressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
  }

  @Basic
  @Column(name = "ADDRESS_LINE2", nullable = true, insertable = true, updatable = true, length = 50)
  public String getAddressLine2() {
    return addressLine2;
  }

  public void setAddressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
  }

  @Basic
  @Column(name = "STATE", nullable = true, insertable = true, updatable = true, length = 50)
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  @Basic
  @Column(name = "COUNTRY", nullable = true, insertable = true, updatable = true, length = 50)
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  @Basic
  @Column(name = "POSTAL_CODE", nullable = true, insertable = true, updatable = true, length = 15)
  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  @Basic
  @Column(name = "TERRITORY", nullable = true, insertable = true, updatable = true, length = 10)
  public String getTerritory() {
    return territory;
  }

  public void setTerritory(String territory) {
    this.territory = territory;
  }


  @OneToMany(mappedBy = "office")
  public Set<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(Set<Employee> employees) {
    this.employees = employees;
  }

  @Override
  public String toString() {
    ToStringBuilder.setDefaultStyle(ToStringStyle.MULTI_LINE_STYLE);
    return new ToStringBuilder(this)
        .append("officeCode", officeCode)
        .append("city", city)
        .append("phone", phone)
        .append("addressLine1", addressLine1)
        .append("addressLine2", addressLine2)
        .append("state", state)
        .append("postalCode", postalCode)
        .append("territory", territory)
        .append("country", country)
        .toString();
  }
}
