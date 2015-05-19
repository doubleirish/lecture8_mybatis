package edu.uw.data.lecture8.mappers

import edu.uw.data.lecture8.model.Payment
import org.apache.ibatis.annotations.Select

/**
 * Created by Conor on 5/7/2015.
 */
public interface PaymentMapper {
/*
 with mapUnderscoreToCamelCase=TRUE  WE DON'T need any special sql aliases

   CUSTOMER_NUMBER INT,
    CHECK_NUMBER VARCHAR(50),
    PAYMENT_DATE DATE,
    AMOUNT FLOAT(52)

  private Integer customerNumber;
  private String checkNumber;
  private Date paymentDate;
  private Double amount;

 */
      //remember SQL not HQL!  no need for xml file this is all thats needed
  @Select(""" SELECT * FROM PAYMENTS  """)
  List<Payment> findAllPayments_LAB();


}