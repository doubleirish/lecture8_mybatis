package edu.uw.data.lecture8.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by credmond on 26/03/15.
 */


public class Office implements Serializable {
  private String officeCode;
  private String city;
  private String phone;
  private String addressLine1;
  private String addressLine2;
  private String state;
  private String country;
  private String postalCode;
  private String territory;
  private OfficeType officeType;
  private Set<Employee> employees =new HashSet<>();



  public String getOfficeCode() {
    return officeCode;
  }

  public void setOfficeCode(String officeCode) {
    this.officeCode = officeCode;
  }



  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }



  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }



  public String getAddressLine1() {
    return addressLine1;
  }

  public void setAddressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
  }



  public String getAddressLine2() {
    return addressLine2;
  }

  public void setAddressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
  }



  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }



  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }



  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }



  public String getTerritory() {
    return territory;
  }

  public void setTerritory(String territory) {
    this.territory = territory;
  }


  public Set<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(Set<Employee> employees) {
    this.employees = employees;
  }

  public OfficeType getOfficeType() {
    return officeType;
  }

  public void setOfficeType(OfficeType officeType) {
    this.officeType = officeType;
  }

  @Override
  public String toString() {
    ToStringBuilder.setDefaultStyle(ToStringStyle.MULTI_LINE_STYLE);
    return new ToStringBuilder(this)
            .append("officeCode", officeCode)
            .append("officeType", officeType)
            .append("city", city)
            .append("phone", phone)
            .append("addressLine1", addressLine1)
            .append("addressLine2", addressLine2)
            .append("state", state)
            .append("country", country)
            .append("postalCode", postalCode)
            .append("territory", territory)

            .toString();
  }
}
