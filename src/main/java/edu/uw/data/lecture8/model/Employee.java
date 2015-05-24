package edu.uw.data.lecture8.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by credmond on 26/03/15.
 */


public class Employee implements Serializable{
  private Integer employeeNumber;
  private String lastName;
  private String firstName;
  private String extension;
  private String email;
  //private String officecode;
  private Employee reportsTo;
  private String jobTitle;
  private Office office;

  private Set<Customer> customers = new HashSet<>();

    public Employee() {
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }



  public Integer getEmployeeNumber() {
    return employeeNumber;
  }

  public void setEmployeeNumber(Integer employeenumber) {
    this.employeeNumber = employeenumber;
  }



  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastname) {
    this.lastName = lastname;
  }



  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstname) {
    this.firstName = firstname;
  }



  public String getExtension() {
    return extension;
  }

  public void setExtension(String extension) {
    this.extension = extension;
  }



  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

//
//
//  public String getOfficecode() {
//    return officecode;
//  }
//
//  public void setOfficecode(String officecode) {
//    this.officecode = officecode;
//  }



  public Employee getReportsTo() {
    return reportsTo;
  }

  public void setReportsTo(Employee reportsto) {
    this.reportsTo = reportsto;
  }



  public String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(String jobtitle) {
    this.jobTitle = jobtitle;
  }




  public Office getOffice() {
    return office;
  }

  public void setOffice(Office office) {
    this.office = office;
  }


  public Set<Customer> getCustomers() {
    return customers;
  }

  public void setCustomers(Set<Customer> customers) {
    this.customers = customers;
  }

    @Override
    public String toString() {
        ToStringBuilder.setDefaultStyle(ToStringStyle.MULTI_LINE_STYLE);
        return new ToStringBuilder(this)
                .append("employeeNumber", employeeNumber)
                .append("lastName", lastName)
                .append("firstName", firstName)
                .append("extension", extension)
                .append("email", email)
              //  .append("reportsTo", reportsTo)
                .append("jobTitle", jobTitle)
             //   .append("office", office)
               // .append("customers", customers)
                .toString();
    }


    //  @Override
//  public String toString() {
//    return "Employee{" +
//        "employeenumber=" + employeeNumber +
//        ", lastname='" + lastName + '\'' +
//        ", firstname='" + firstName + '\'' +
//        ", extension='" + extension + '\'' +
//        ", email='" + email + '\'' +
//       // ", reportsto=" + reportsTo +
//        ", jobtitle='" + jobTitle + '\'' +
//       // ", office=" + office +
//        //", customers=" + customers +
//        '}';
//  }
}
