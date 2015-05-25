package edu.uw.data.lecture8.mappers;

import edu.uw.data.lecture8.dto.SearchCustomerForm;
import edu.uw.data.lecture8.model.Customer;

import java.util.List;

/**
 * Created by Conor on 5/7/2015.
 */
public interface SearchMapper {



    // QBE like example dynamic sql
    List<Customer> searchCustomers(SearchCustomerForm form);

    // example of an option JOIN in a dynamic sql query
    List<Customer> searchCustomersWhoPurchasedAProductLine(SearchCustomerForm form);


}