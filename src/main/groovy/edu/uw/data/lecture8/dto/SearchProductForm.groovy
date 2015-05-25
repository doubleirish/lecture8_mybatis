package edu.uw.data.lecture8.dto

/**
 * Created by Conor on 5/24/2015.
 */
class SearchProductForm {
    String productCode;
    String productName;
    String productLine;
    String productScale;
    String productVendor;
    String productDescription;

    Integer quantityInStockGreaterThan;
    Integer quantityInStockLessThan;

    Double buyPrice;

    Double msrp;


}
