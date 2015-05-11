package edu.uw.data.lecture8.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by Conor on 5/10/2015.
 */
public class CustomerSalesReportDetail {
    Integer customerNumber;
    String  customerName;
    Integer totalSales;

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Integer totalSales) {
        this.totalSales = totalSales;
    }

    @Override
    public String toString() {
        ToStringBuilder.setDefaultStyle(ToStringStyle.MULTI_LINE_STYLE) ;

        return new ToStringBuilder(this)
                .append("customerNumber", customerNumber)
                .append("customerName", customerName)
                .append("totalSales", totalSales)
                .toString();
    }
}
