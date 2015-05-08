package edu.uw.data.lecture8.model;

import javax.persistence.*;

/**
 * Created by credmond on 26/03/15.
 */
@Entity
@Table(name = "PRODUCTS", schema = "APP", catalog = "")
public class Product {
  private String productcode;
  private String productname;
  private String productline;
  private String productscale;
  private String productvendor;
  private String productdescription;
  private Integer quantityinstock;
  private Double buyprice;
  private Double msrp;
  private Productline productlinesByProductline;

  @Id
  @Column(name = "PRODUCT_CODE", nullable = false, insertable = true, updatable = true, length = 15)
  public String getProductcode() {
    return productcode;
  }

  public void setProductcode(String productcode) {
    this.productcode = productcode;
  }

  @Basic
  @Column(name = "PRODUCT_NAME", nullable = true, insertable = true, updatable = true, length = 70)
  public String getProductname() {
    return productname;
  }

  public void setProductname(String productname) {
    this.productname = productname;
  }

//  @Basic
//  @Column(name = "PRODUCT_LINE", nullable = true, insertable = true, updatable = true, length = 50)
//  public String getProductline() {
//    return productline;
//  }
//
//  public void setProductline(String productline) {
//    this.productline = productline;
//  }

  @Basic
  @Column(name = "PRODUCT_SCALE", nullable = true, insertable = true, updatable = true, length = 10)
  public String getProductscale() {
    return productscale;
  }

  public void setProductscale(String productscale) {
    this.productscale = productscale;
  }

  @Basic
  @Column(name = "PRODUCT_VENDOR", nullable = true, insertable = true, updatable = true, length = 50)
  public String getProductvendor() {
    return productvendor;
  }

  public void setProductvendor(String productvendor) {
    this.productvendor = productvendor;
  }

//  @Basic
//  @Column(name = "PRODUCT_DESCRIPTION", nullable = true, insertable = true, updatable = true, length = 32700)
//  public String getProductdescription() {
//    return productdescription;
//  }
//
//  public void setProductdescription(String productdescription) {
//    this.productdescription = productdescription;
//  }

  @Basic
  @Column(name = "QUANTITY_IN_STOCK", nullable = true, insertable = true, updatable = true)
  public Integer getQuantityinstock() {
    return quantityinstock;
  }

  public void setQuantityinstock(Integer quantityinstock) {
    this.quantityinstock = quantityinstock;
  }

  @Basic
  @Column(name = "BUY_PRICE", nullable = true, insertable = true, updatable = true, precision = 0)
  public Double getBuyprice() {
    return buyprice;
  }

  public void setBuyprice(Double buyprice) {
    this.buyprice = buyprice;
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
  public Productline getProductlinesByProductline() {
    return productlinesByProductline;
  }

  public void setProductlinesByProductline(Productline productlinesByProductline) {
    this.productlinesByProductline = productlinesByProductline;
  }
}
