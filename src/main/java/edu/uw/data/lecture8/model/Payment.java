package edu.uw.data.lecture8.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.sql.Date;

/**
 * Created by credmond on 26/03/15.
 */



public class Payment {
  private Integer customerNumber;
  private String checkNumber;
  private Date paymentDate;
  private Double amount;



  public Integer getCustomerNumber() {
    return customerNumber;
  }

  public void setCustomerNumber(Integer customerNumber) {
    this.customerNumber = customerNumber;
  }




  public String getCheckNumber() {
    return checkNumber;
  }

  public void setCheckNumber(String checkNumber) {
    this.checkNumber = checkNumber;
  }



  public Date getPaymentDate() {
    return paymentDate;
  }

  public void setPaymentDate(Date paymentDate) {
    this.paymentDate = paymentDate;
  }



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

    @Override
    public String toString() {
        ToStringBuilder.setDefaultStyle(ToStringStyle.MULTI_LINE_STYLE);
        return new ToStringBuilder(this)
                .append("customerNumber", customerNumber)
                .append("checkNumber", checkNumber)
                .append("paymentDate", paymentDate)
                .append("amount", amount)
                .toString();
    }
}
