package edu.uw.data.lecture8.reports;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Conor on 5/7/2015.
 */
public interface CustomerMapper {

    @Select("SELECT * FROM CUSTOMERS") //SQL not HQL!
    List findAllCustomers( );


//    @Select("SELECT * FROM CUSTOMERS  WHERE CUSTOMERNUMBER = #{customerNumber}") //SQL not HQL!
//    Customer findCustomerByCustomerNumber(@Param("customerNumber") String customerNumber);
}