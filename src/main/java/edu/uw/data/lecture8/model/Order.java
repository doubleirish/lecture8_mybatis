package edu.uw.data.lecture8.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

/**
 * Created by credmond on 26/03/15.
 */



public class Order  implements Serializable{
  private Integer orderNumber;
  private Date orderDate;
  private Date requiredDate;
  private Date shippedDate;
  private String status;
  private String comments;
  private Integer customerNumber;


  private OrderDetail orderDetail;


  public Integer getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(Integer ordernumber) {
    this.orderNumber = ordernumber;
  }



  public Date getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Date orderdate) {
    this.orderDate = orderdate;
  }



  public Date getRequiredDate() {
    return requiredDate;
  }

  public void setRequiredDate(Date requireddate) {
    this.requiredDate = requireddate;
  }



  public Date getShippedDate() {
    return shippedDate;
  }

  public void setShippedDate(Date shippeddate) {
    this.shippedDate = shippeddate;
  }



  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public Integer getCustomerNumber() {
    return customerNumber;
  }

  public void setCustomerNumber(Integer customerNumber) {
    this.customerNumber = customerNumber;
  }

  public OrderDetail getOrderDetail() {
    return orderDetail;
  }

  public void setOrderDetail(OrderDetail orderDetail) {
    this.orderDetail = orderDetail;
  }


    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .append("orderNumber", orderNumber)
            .append("orderDate", orderDate)
            .append("requiredDate", requiredDate)
            .append("shippedDate", shippedDate)
            .append("status", status)
            .append("comments", comments)
            .append("customerNumber", customerNumber)
            .append("orderDetail", orderDetail)
            .toString();
  }

  @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(orderNumber, order.orderNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber);
    }
}
