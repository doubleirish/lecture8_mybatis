package edu.uw.data.lecture8.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by credmond on 26/03/15.
 */

public class PaymentPK implements Serializable {
  private Integer customerNumber;
  private String checkNumber;


  @Id
  public Integer getCustomerNumber() {
    return customerNumber;
  }

  public void setCustomerNumber(Integer customerNumber) {
    this.customerNumber = customerNumber;
  }



  @Id
  public String getCheckNumber() {
    return checkNumber;
  }

  public void setCheckNumber(String checkNumber) {
    this.checkNumber = checkNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PaymentPK paymentPK = (PaymentPK) o;

    if (checkNumber != null ? !checkNumber.equals(paymentPK.checkNumber) : paymentPK.checkNumber != null) return false;
    if (customerNumber != null ? !customerNumber.equals(paymentPK.customerNumber) : paymentPK.customerNumber != null)
      return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = customerNumber != null ? customerNumber.hashCode() : 0;
    result = 31 * result + (checkNumber != null ? checkNumber.hashCode() : 0);
    return result;
  }
}
