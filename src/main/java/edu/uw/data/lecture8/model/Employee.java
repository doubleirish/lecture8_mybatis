package edu.uw.data.lecture8.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by credmond on 26/03/15.
 */
@Entity
@Table(name = "EMPLOYEES" )
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

  @Id
  @Column(name = "EMPLOYEE_NUMBER", nullable = false, insertable = true, updatable = true)
  public Integer getEmployeeNumber() {
    return employeeNumber;
  }

  public void setEmployeeNumber(Integer employeenumber) {
    this.employeeNumber = employeenumber;
  }

  @Basic
  @Column(name = "LAST_NAME", nullable = true, insertable = true, updatable = true, length = 50)
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastname) {
    this.lastName = lastname;
  }

  @Basic
  @Column(name = "FIRST_NAME", nullable = true, insertable = true, updatable = true, length = 50)
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstname) {
    this.firstName = firstname;
  }

  @Basic
  @Column(name = "EXTENSION", nullable = true, insertable = true, updatable = true, length = 10)
  public String getExtension() {
    return extension;
  }

  public void setExtension(String extension) {
    this.extension = extension;
  }

  @Basic
  @Column(name = "EMAIL", nullable = true, insertable = true, updatable = true, length = 100)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

//  @Basic
//  @Column(name = "OFFICE_CODE", nullable = true, insertable = true, updatable = true, length = 10)
//  public String getOfficecode() {
//    return officecode;
//  }
//
//  public void setOfficecode(String officecode) {
//    this.officecode = officecode;
//  }

  @ManyToOne
  @JoinColumn(name = "REPORTS_TO" ,referencedColumnName = "EMPLOYEE_NUMBER")
  public Employee getReportsTo() {
    return reportsTo;
  }

  public void setReportsTo(Employee reportsto) {
    this.reportsTo = reportsto;
  }

  @Basic
  @Column(name = "JOB_TITLE", nullable = true, insertable = true, updatable = true, length = 50)
  public String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(String jobtitle) {
    this.jobTitle = jobtitle;
  }


  @ManyToOne()
  @JoinColumn(name = "OFFICE_CODE" ,referencedColumnName = "OFFICE_CODE")
  public Office getOffice() {
    return office;
  }

  public void setOffice(Office office) {
    this.office = office;
  }

  @OneToMany(mappedBy = "salesRep")
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
