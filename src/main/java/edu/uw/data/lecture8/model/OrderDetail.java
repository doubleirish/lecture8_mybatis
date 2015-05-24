package edu.uw.data.lecture8.model;

import java.io.Serializable;

/**
 * Created by credmond on 26/03/15.
 */


public class OrderDetail implements Serializable {
  private Integer orderNumber;
  private Product product;
  private Integer quantityOrdered;
  private Double priceEach;
  private Short orderLineNumber;



  public Integer getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(Integer ordernumber) {
    this.orderNumber = ordernumber;
  }



  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product ) {
    this.product = product;
  }



  public Integer getQuantityOrdered() {
    return quantityOrdered;
  }

  public void setQuantityOrdered(Integer quantityordered) {
    this.quantityOrdered = quantityordered;
  }



  public Double getPriceEach() {
    return priceEach;
  }

  public void setPriceEach(Double priceeach) {
    this.priceEach = priceeach;
  }



  public Short getOrderLineNumber() {
    return orderLineNumber;
  }

  public void setOrderLineNumber(Short orderlinenumber) {
    this.orderLineNumber = orderlinenumber;
  }

  @Override
  public String toString() {
    return "OrderDetail{" +
        "orderNumber=" + orderNumber +
      //  ", productCode='" + productCode + '\'' +
        ", quantityOrdered=" + quantityOrdered +
        ", priceEach=" + priceEach +
        ", orderLineNumber=" + orderLineNumber +
        '}';
  }
}
