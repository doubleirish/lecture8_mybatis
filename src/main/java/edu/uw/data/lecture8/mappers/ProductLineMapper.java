package edu.uw.data.lecture8.mappers;

import edu.uw.data.lecture8.model.ProductLine;

import java.util.List;

/**
 * Created by Conor on 5/7/2015.
 */
public interface ProductLineMapper {

//    public class ProductLine {
//        private String productLine;
//        private String textDescription;



//    CREATE TABLE PRODUCT_LINES  (
//         PRODUCT_LINE VARCHAR(50),
//         TEXT_DESCRIPTION VARCHAR(4000)
//    );


    // TODO LAB 1 add a @Select  to map the PRODUCT_LINE table to the ProductLine class
    List<ProductLine> findAllProductLines();

    // TODO LAB 2 : add a @Select  to map the PRODUCT_LINE table to the ProductLine class as before
    // TODO LAB 2 : plus include   an extra where clause making use of a passed in @Param paremeter
     ProductLine findById(String productLine);

}