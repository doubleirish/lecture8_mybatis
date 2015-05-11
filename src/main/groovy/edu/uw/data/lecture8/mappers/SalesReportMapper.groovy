package edu.uw.data.lecture8.mappers
import edu.uw.data.lecture8.dto.CustomerSalesReportDetail
import org.apache.ibatis.annotations.ResultType
import org.apache.ibatis.annotations.Select
/**
 * no config file.
 * map results to a DTO
 */
public interface SalesReportMapper {


@Select("""
        SELECT
          C.CUSTOMER_NUMBER  AS customerNumber
           ,  C.CUSTOMER_NAME AS customerName
           , SUM (P.AMOUNT) AS totalSales
        FROM CUSTOMERS C
            JOIN PAYMENTS P ON C.CUSTOMER_NUMBER  =P.CUSTOMER_NUMBER
        GROUP BY C.CUSTOMER_NUMBER  ,C.CUSTOMER_NAME
          HAVING SUM (P.AMOUNT) >10000
          ORDER BY SUM (P.AMOUNT) DESC
           """ )

List<CustomerSalesReportDetail> findBestCustomers();


    @Select("""
        select
           p.PRODUCT_NAME
        , sum(od.QUANTITY_ORDERED * od.PRICE_EACH) as totalSales

        from ORDER_DETAILS od
          join PRODUCTS p  on od.PRODUCT_CODE  =p.PRODUCT_CODE
        group by p.PRODUCT_NAME
        order by totalSales desc
         """ )
    @ResultType(value=java.util.HashMap)  // don't want to clutter up the place with throwaway DTO result classes ? use HashMap
    List<Map> findMostPopularProducts();



}