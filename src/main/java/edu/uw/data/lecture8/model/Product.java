package edu.uw.data.lecture8.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by credmond on 26/03/15.
 */


public class Product implements Serializable {
  private String productCode;
  private String productName;
  private String productLine;
  private String productScale;
  private String productVendor;
  private String productDescription;
  private Integer quantityInStock;
  private Double buyPrice;
  private Double msrp;



  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }



  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }



  public String getProductLine() {
    return productLine;
  }

  public void setProductLine(String productLine) {
    this.productLine = productLine;
  }



  public String getProductScale() {
    return productScale;
  }

  public void setProductScale(String productScale) {
    this.productScale = productScale;
  }



  public String getProductVendor() {
    return productVendor;
  }

  public void setProductVendor(String productVendor) {
    this.productVendor = productVendor;
  }

//
//
//  public String getProductdescription() {
//    return productDescription;
//  }
//
//  public void setProductdescription(String productDescription) {
//    this.productDescription = productDescription;
//  }



  public Integer getQuantityInStock() {
    return quantityInStock;
  }

  public void setQuantityInStock(Integer quantityInStock) {
    this.quantityInStock = quantityInStock;
  }



  public Double getBuyPrice() {
    return buyPrice;
  }

  public void setBuyPrice(Double buyPrice) {
    this.buyPrice = buyPrice;
  }



  public Double getMsrp() {
    return msrp;
  }

  public void setMsrp(Double msrp) {
    this.msrp = msrp;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Product)) return false;
    Product product = (Product) o;
    return Objects.equals(productCode, product.productCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productCode);
  }

  @Override
    public String toString() {
        ToStringBuilder.setDefaultStyle(ToStringStyle.MULTI_LINE_STYLE);
        return new ToStringBuilder(this)
                .append("productCode", productCode)
                .append("productName", productName)
                .append("productLine", productLine)
                .append("productScale", productScale)
                .append("productVendor", productVendor)
                .append("productDescription", productDescription)
                .append("quantityInStock", quantityInStock)
                .append("buyPrice", buyPrice)
                .append("msrp", msrp)

                .toString();
    }
}
