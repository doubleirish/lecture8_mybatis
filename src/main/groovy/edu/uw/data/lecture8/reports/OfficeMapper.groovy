package edu.uw.data.lecture8.reports

import edu.uw.data.lecture8.model.Office
import org.apache.ibatis.annotations.Select

/**
 * Created by Conor on 5/7/2015.
 */
public interface OfficeMapper {

      //remember SQL not HQL!
  @Select("""
  SELECT
    OFFICE_CODE    as officeCode
    ,PHONE
    ,ADDRESS_LINE1 as addressLine1
    ,ADDRESS_LINE2 as addressLine2
    ,CITY
    ,STATE
    ,POSTAL_CODE   as postalCode
    ,TERRITORY     as territory
    ,COUNTRY       as country
  FROM OFFICES
  """)
  List<Office> findAllOffices();


//    @Select("SELECT * FROM CUSTOMERS  WHERE CUSTOMER_NUMBER = #{customerNumber}") //SQL not HQL!
//    Customer findCustomerByCustomerNumber(@Param("customerNumber") String customerNumber);
}