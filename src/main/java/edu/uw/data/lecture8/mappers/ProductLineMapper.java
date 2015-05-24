package edu.uw.data.lecture8.mappers;

import edu.uw.data.lecture8.model.ProductLine;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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


    //    add a @Select  to map the PRODUCT_LINE table to the ProductLine class
    @Select( "SELECT * FROM PRODUCT_LINES")
    List<ProductLine> findAllProductLines();

    //     add a @Select  to map the PRODUCT_LINE table to the ProductLine class as before
    //     :  also  include   an extra "WHERE" clause making use of a passed in @Param paremeter
    @Select( "SELECT * FROM PRODUCT_LINES WHERE PRODUCT_LINE = #{prodLine}")
     ProductLine findById(@Param("prodLine") String productLine);


    ProductLine findProductLineByIdWithProducts_NESTED_RESULTS(String productLine);

    ProductLine findProductLineByIdWithProducts_NESTED_SELECT(String productLine);

}