package edu.uw.data.lecture8.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by credmond on 26/03/15.
 */



public class Customer implements Serializable {
  private Integer customerNumber;
  private String customerName;
  private String contactLastname;
  private String contactFirstname;
  private String phone;
  private String addressLine1;
  private String addressLine2;
  private String city;
  private String state;
  private String postalCode;
  private String country;
  //private Integer salesRepEmployeeNumber;
  private Double creditLimit;

  private Set<Order> orders = new HashSet<>();
  private Set<Payment> payments = new HashSet<>();
  private Employee salesRep ;



  public Integer getCustomerNumber() {
    return customerNumber;
  }

  public void setCustomerNumber(Integer customernumber) {
    this.customerNumber = customernumber;
  }



  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customername) {
    this.customerName = customername;
  }



  public String getContactLastname() {
    return contactLastname;
  }

  public void setContactLastname(String contactlastname) {
    this.contactLastname = contactlastname;
  }



  public String getContactFirstname() {
    return contactFirstname;
  }

  public void setContactFirstname(String contactfirstname) {
    this.contactFirstname = contactfirstname;
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

  public void setAddressLine1(String addressline1) {
    this.addressLine1 = addressline1;
  }



  public String getAddressLine2() {
    return addressLine2;
  }

  public void setAddressLine2(String addressline2) {
    this.addressLine2 = addressline2;
  }



  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }



  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }



  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalcode) {
    this.postalCode = postalcode;
  }



  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

//
//
//  public Integer getSalesRepEmployeeNumber() {
//    return salesRepEmployeeNumber;
//  }
//
//  public void setSalesRepEmployeeNumber(Integer salesrepemployeenumber) {
//    this.salesRepEmployeeNumber = salesrepemployeenumber;
//  }



  public Double getCreditLimit() {
    return creditLimit;
  }

  public void setCreditLimit(Double creditlimit) {
    this.creditLimit = creditlimit;
  }



  public Set<Order> getOrders() {
    return orders;
  }

  public void setOrders(Set<Order> orders) {
    this.orders = orders;
  }




  public Employee getSalesRep() {
    return salesRep;
  }

  public void setSalesRep(Employee salesRep) {
    this.salesRep = salesRep;
  }


  public Set<Payment> getPayments() {
    return payments;
  }

  public void setPayments(Set<Payment> payments) {
    this.payments = payments;
  }

  @Override
  public String toString() {
    return "Customer{" +
        "customernumber=" + customerNumber +
        ", customername='" + customerName + '\'' +
        ", contactlastname='" + contactLastname + '\'' +
        ", contactfirstname='" + contactFirstname + '\'' +
        ", phone='" + phone + '\'' +
        ", addressline1='" + addressLine1 + '\'' +
        ", addressline2='" + addressLine2 + '\'' +
        ", city='" + city + '\'' +
        ", state='" + state + '\'' +
        ", postalcode='" + postalCode + '\'' +
        ", country='" + country + '\'' +
        ", creditlimit=" + creditLimit +
        '}';
  }
}
