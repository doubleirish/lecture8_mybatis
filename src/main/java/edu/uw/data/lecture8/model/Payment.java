package edu.uw.data.lecture8.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by credmond on 26/03/15.
 */
@Entity
@Table(name = "PAYMENTS", schema = "APP", catalog = "")
@IdClass(PaymentPK.class)
public class Payment {
  private Integer customerNumber;
  private String checkNumber;
  private Date paymentDate;
  private Double amount;

  @Id
  @Column(name = "CUSTOMER_NUMBER", nullable = false, insertable = true, updatable = true)
  public Integer getCustomerNumber() {
    return customerNumber;
  }

  public void setCustomerNumber(Integer customerNumber) {
    this.customerNumber = customerNumber;
  }

  @Id
  @Basic
  @Column(name = "CHECK_NUMBER", nullable = false, insertable = true, updatable = true, length = 50)
  public String getCheckNumber() {
    return checkNumber;
  }

  public void setCheckNumber(String checkNumber) {
    this.checkNumber = checkNumber;
  }

  @Basic
  @Column(name = "PAYMENT_DATE", nullable = true, insertable = true, updatable = true)
  public Date getPaymentDate() {
    return paymentDate;
  }

  public void setPaymentDate(Date paymentDate) {
    this.paymentDate = paymentDate;
  }

  @Basic
  @Column(name = "AMOUNT", nullable = true, insertable = true, updatable = true, precision = 0)
  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Payment payment = (Payment) o;

    if (amount != null ? !amount.equals(payment.amount) : payment.amount != null) return false;
    if (checkNumber != null ? !checkNumber.equals(payment.checkNumber) : payment.checkNumber != null) return false;
    if (customerNumber != null ? !customerNumber.equals(payment.customerNumber) : payment.customerNumber != null)
      return false;
    if (paymentDate != null ? !paymentDate.equals(payment.paymentDate) : payment.paymentDate != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = customerNumber != null ? customerNumber.hashCode() : 0;
    result = 31 * result + (checkNumber != null ? checkNumber.hashCode() : 0);
    result = 31 * result + (paymentDate != null ? paymentDate.hashCode() : 0);
    result = 31 * result + (amount != null ? amount.hashCode() : 0);
    return result;
  }
}
