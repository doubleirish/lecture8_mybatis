package edu.uw.data.lecture8.model;

import javax.persistence.*;

/**
 * Created by credmond on 26/03/15.
 */
@Entity
@Table(name = "PRODUCT_LINES", schema = "APP", catalog = "")
public class Productline {
  private String productline;
  private String textdescription;
  private String htmldescription;
  private byte[] image;

  @Id
  @Column(name = "PRODUCT_LINE")
  public String getProductline() {
    return productline;
  }

  public void setProductline(String productline) {
    this.productline = productline;
  }

  @Basic
  @Column(name = "TEXT_DESCRIPTION", nullable = true, insertable = true, updatable = true, length = 4000)
  public String getTextdescription() {
    return textdescription;
  }

  public void setTextdescription(String textdescription) {
    this.textdescription = textdescription;
  }

//  @Basic
//  @Column(name = "HTML_DESCRIPTION", nullable = true, insertable = true, updatable = true)
//  public String getHtmldescription() {
//    return htmldescription;
//  }
//
//  public void setHtmldescription(String htmldescription) {
//    this.htmldescription = htmldescription;
//  }

//  @Basic
//  @Column(name = "IMAGE", nullable = true, insertable = true, updatable = true)
//  public byte[] getImage() {
//    return image;
//  }
//
//  public void setImage(byte[] image) {
//    this.image = image;
//  }
//

}
