package edu.uw.data.lecture8.reports;

import edu.uw.data.lecture8.model.Customer;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Conor on 5/7/2015.
 */
public interface CustomerMapper {
  //
//  private Integer customerNumber;
//  private String customerName;
//  private String contactLastname;
//  private String contactFirstname;
//  private String phone;
//  private String addressLine1;
//  private String addressLine2;
//  private String city;
//  private String state;
//  private String postalCode;
//  private String country;


//     CUSTOMER_NUMBER INT,
//     CUSTOMER_NAME VARCHAR(50),
//     CONTACT_LAST_NAME VARCHAR(50),
//     CONTACT_FIRST_NAME VARCHAR(50),
//     PHONE VARCHAR(50),
//     ADDRESS_LINE1 VARCHAR(50),
//     ADDRESS_LINE2 VARCHAR(50),
//     CITY VARCHAR(50),
//     STATE VARCHAR(50),
//     POSTAL_CODE VARCHAR(15),
//     COUNTRY VARCHAR(50),
//     SALES_REP_EMPLOYEE_NUMBER INT,
//     CREDIT_LIMIT FLOAT(52)

  @Select("SELECT CUSTOMER_NUMBER as customerNumber FROM CUSTOMERS")
    //SQL not HQL!
  List<Customer> findAllCustomers();


//    @Select("SELECT * FROM CUSTOMERS  WHERE CUSTOMER_NUMBER = #{customerNumber}") //SQL not HQL!
//    Customer findCustomerByCustomerNumber(@Param("customerNumber") String customerNumber);
}