package edu.uw.data.lecture8.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

/**
 * Created by credmond on 26/03/15.
 */
@NamedQueries({
        @NamedQuery(name = "Order.findAll",
                query = "SELECT o from Order o")

})
@Entity
@Table(name = "ORDERS" )
public class Order  implements Serializable{
  private Integer orderNumber;
  private Date orderDate;
  private Date requiredDate;
  private Date shippedDate;
  private String status;
    private String comments;
  private Customer customer;


  private OrderDetail orderDetail;
  @Id
  @Column(name = "ORDER_NUMBER" )
  public Integer getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(Integer ordernumber) {
    this.orderNumber = ordernumber;
  }

  @Basic
  @Column(name = "ORDER_DATE", nullable = true, insertable = true, updatable = true)
  public Date getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Date orderdate) {
    this.orderDate = orderdate;
  }

  @Basic
  @Column(name = "REQUIRED_DATE", nullable = true, insertable = true, updatable = true)
  public Date getRequiredDate() {
    return requiredDate;
  }

  public void setRequiredDate(Date requireddate) {
    this.requiredDate = requireddate;
  }

  @Basic
  @Column(name = "SHIPPED_DATE", nullable = true, insertable = true, updatable = true)
  public Date getShippedDate() {
    return shippedDate;
  }

  public void setShippedDate(Date shippeddate) {
    this.shippedDate = shippeddate;
  }

  @Basic
  @Column(name = "STATUS", nullable = true, insertable = true, updatable = true, length = 15)
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }



  @ManyToOne
  @JoinColumn(name = "CUSTOMER_NUMBER", // col name in ORDER table
      referencedColumnName = "CUSTOMER_NUMBER") // col name in CUSTOMER table
  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customersByCustomernumber) {
    this.customer = customersByCustomernumber;
  }

  @OneToOne //shared primary key
  @PrimaryKeyJoinColumn
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
