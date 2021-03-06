package edu.uw.data.lecture8.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by credmond on 26/03/15.
 */
@Entity
@Table(name = "PRODUCT_LINES", schema = "APP", catalog = "")
public class ProductLine implements Serializable {
    private String productLine;
    private String textDescription;


    @Id
    @Column(name = "PRODUCT_LINE")
    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    @Basic
    @Column(name = "TEXT_DESCRIPTION", nullable = true, insertable = true, updatable = true, length = 4000)
    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("productLine", productLine)
                .append("textDescription", textDescription)
                .toString();
    }
}
