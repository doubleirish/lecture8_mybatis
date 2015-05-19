package edu.uw.data.lecture8.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by credmond on 26/03/15.
 */
@Entity
@Table(name = "ORDER_DETAILS" )
public class OrderDetail implements Serializable {
  private Integer orderNumber;
  private Product product;
  private Integer quantityOrdered;
  private Double priceEach;
  private Short orderLineNumber;

  @Id
  @Column(name = "ORDER_NUMBER" )
  public Integer getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(Integer ordernumber) {
    this.orderNumber = ordernumber;
  }

  @ManyToOne
  @JoinColumn(name = "PRODUCT_CODE")
  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product ) {
    this.product = product;
  }

  @Basic
  @Column(name = "QUANTITY_ORDERED", nullable = true, insertable = true, updatable = true)
  public Integer getQuantityOrdered() {
    return quantityOrdered;
  }

  public void setQuantityOrdered(Integer quantityordered) {
    this.quantityOrdered = quantityordered;
  }

  @Basic
  @Column(name = "PRICE_EACH", nullable = true, insertable = true, updatable = true, precision = 0)
  public Double getPriceEach() {
    return priceEach;
  }

  public void setPriceEach(Double priceeach) {
    this.priceEach = priceeach;
  }

  @Basic
  @Column(name = "ORDER_LINE_NUMBER", nullable = true, insertable = true, updatable = true)
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
