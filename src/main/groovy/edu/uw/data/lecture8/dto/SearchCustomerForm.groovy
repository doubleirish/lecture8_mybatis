package edu.uw.data.lecture8.dto

import edu.uw.data.lecture8.model.Employee
import edu.uw.data.lecture8.model.Product

/**
 * Created by Conor on 5/24/2015.
 */
class SearchCustomerForm {
     Integer customerNumber;
     String customerName;
     String contactLastName;
     String contactFirstName;
     String phone;
     String city;
     String state;
     String postalCode;
     String country;
     Double creditLimitGreaterThanOrEqual
     Double creditLimitLessThanOrEqual

     // foreach example
     List<String> states  ;

     // complex multi table join query on customers who purchased a product from a product line
     String productLine;

     Product productPurchased;
     Employee salesRep;

     Double  salesGreaterThan;
     Double  salesLessThan;

     Double  paymentsGreaterThan;
     Double  paymentsLessThan;

}
