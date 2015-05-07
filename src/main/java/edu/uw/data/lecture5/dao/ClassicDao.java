package edu.uw.data.lecture5.dao;


import edu.uw.data.lecture5.model.Customer;
import edu.uw.data.lecture5.model.Employee;
import edu.uw.data.lecture5.model.Office;
import edu.uw.data.lecture5.model.Order;

import java.util.List;

/**
 * Created by credmond on 03/03/15.
 */
interface ClassicDao {
    // HQL examples
    List<Office> findAllOffices();
    List<Customer> findAllCustomersInUsState(String usState);
    Customer findCustomerByCustomerName(String customerName);
    List<Order> findRecentOrdersForCustomer(Customer customer);

    // sql injection friendly example
    List<Customer> findCustomerByCustNum_STRING_CONCAT_BAD(String customerNum);


    // equi join example
    List<Object[]> findSalesOfficeForEachCustomer();

    // QBE Example
    List<Customer> findCustomers_QueryByExample(Customer cust);

    //QBE Lab
    List<Office> findOffices_QueryByExample(Office office);


    //Criteria untyped api examples
    List<Customer> findCustomersByCriteriaOR(Customer customerSearch);

    List<Employee> findEmployeeByNameCriteriaAND(Employee search);


    //Criteria typed api example
    List<Customer> findCustomerInStateWithCreditLimitGreaterThan(String usState, Double minimumCreditLimit);

    //named Query
    List<Customer> findCustomerByFirstAndLast_namedQuery(String first, String last);

    //named query lab
    List<Customer> findCustomersByCity(String city);

    //execute arbitrary HQL for people who don't have the IDE JPQL Console support, NEVER on production
    List<Object[]> runHQL(String hql);

}
