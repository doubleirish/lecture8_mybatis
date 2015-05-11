package edu.uw.data.lecture8.model;

import javax.persistence.*;

/**
 * Created by credmond on 26/03/15.
 */
@Entity
@Table(name = "PRODUCTS", schema = "APP", catalog = "")
public class Product {
  private String productCode;
  private String productName;
  private String productLine;
  private String productScale;
  private String productVendor;
  private String productDescription;
  private Integer quantityInStock;
  private Double buyPrice;
  private Double msrp;
  private ProductLine productLinesByProductLine;

  @Id
  @Column(name = "PRODUCT_CODE", nullable = false, insertable = true, updatable = true, length = 15)
  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  @Basic
  @Column(name = "PRODUCT_NAME", nullable = true, insertable = true, updatable = true, length = 70)
  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

//  @Basic
//  @Column(name = "PRODUCT_LINE", nullable = true, insertable = true, updatable = true, length = 50)
//  public String getProductLine() {
//    return productLine;
//  }
//
//  public void setProductLine(String productLine) {
//    this.productLine = productLine;
//  }

  @Basic
  @Column(name = "PRODUCT_SCALE", nullable = true, insertable = true, updatable = true, length = 10)
  public String getProductScale() {
    return productScale;
  }

  public void setProductScale(String productScale) {
    this.productScale = productScale;
  }

  @Basic
  @Column(name = "PRODUCT_VENDOR", nullable = true, insertable = true, updatable = true, length = 50)
  public String getProductVendor() {
    return productVendor;
  }

  public void setProductVendor(String productVendor) {
    this.productVendor = productVendor;
  }

//  @Basic
//  @Column(name = "PRODUCT_DESCRIPTION", nullable = true, insertable = true, updatable = true, length = 32700)
//  public String getProductdescription() {
//    return productDescription;
//  }
//
//  public void setProductdescription(String productDescription) {
//    this.productDescription = productDescription;
//  }

  @Basic
  @Column(name = "QUANTITY_IN_STOCK", nullable = true, insertable = true, updatable = true)
  public Integer getQuantityInStock() {
    return quantityInStock;
  }

  public void setQuantityInStock(Integer quantityInStock) {
    this.quantityInStock = quantityInStock;
  }

  @Basic
  @Column(name = "BUY_PRICE", nullable = true, insertable = true, updatable = true, precision = 0)
  public Double getBuyPrice() {
    return buyPrice;
  }

  public void setBuyPrice(Double buyPrice) {
    this.buyPrice = buyPrice;
  }

  @Basic
  @Column(name = "MSRP", nullable = true, insertable = true, updatable = true, precision = 0)
  public Double getMsrp() {
    return msrp;
  }

  public void setMsrp(Double msrp) {
    this.msrp = msrp;
  }



  @ManyToOne
  @JoinColumn(name = "PRODUCT_LINE", referencedColumnName = "PRODUCT_LINE")
  public ProductLine getProductLinesByProductLine() {
    return productLinesByProductLine;
  }

  public void setProductLinesByProductLine(ProductLine productLinesByProductLine) {
    this.productLinesByProductLine = productLinesByProductLine;
  }
}
