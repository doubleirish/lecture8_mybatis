package edu.uw.data.lecture8.mappers

import edu.uw.data.lecture8.model.Office
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.Select

/**
 * Created by Conor on 5/7/2015.
 */
public interface OfficeMapper {

      //remember SQL not HQL!  no need for xml file this is all thats needed
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


// @Select("SELECT * FROM CUSTOMERS  WHERE CUSTOMER_NUMBER = #{customerNumber}") //SQL not HQL!
//   Customer findCustomerByCustomerNumber(@Param("customerNumber") String customerNumber);

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
              WHERE  OFFICE_CODE  =   #{officeCode}
  """)
    Office findOfficeByCode(@Param("officeCode") String officeCode);


    @Results(value = [ //groovy uses square brackets , java uses curly brackets
            @Result(column = "OFFICE_CODE", property = "officeCode"),
            @Result(column = "PHONE", property = "phone"),
            @Result(column = "ADDRESS_LINE1", property = "addressLine1"),
            @Result(column = "ADDRESS_LINE2", property = "addressLine2"),
            @Result(column = "CITY", property = "city"),
            @Result(column = "STATE", property = "state"),
            @Result(column = "POSTAL_CODE", property = "postalCode"),
            @Result(column = "TERRITORY", property = "territory"),
            @Result(column = "COUNTRY", property = "country"),
    ])
    @Select("SELECT * FROM OFFICES WHERE OFFICE_CODE = #{officeCode} ")
    Office findOfficeByCode_ANNOTATED_RESULT_MAPPING(@Param("officeCode") String officeCode);

    // see XML mapper file for nested mapping
    List<Office> findAllOffices_XML_NESTED();


}