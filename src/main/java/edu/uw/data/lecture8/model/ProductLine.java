package edu.uw.data.lecture8.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by credmond on 26/03/15.
 */


public class ProductLine implements Serializable {
    private String productLine;
    private String textDescription;
    private Set<Product> products =new HashSet<>();

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }



    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }


    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductLine)) return false;
        ProductLine that = (ProductLine) o;
        return Objects.equals(productLine, that.productLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productLine);
    }

    @Override
    public String toString() {
        ToStringBuilder.setDefaultStyle(ToStringStyle.MULTI_LINE_STYLE);
        return new ToStringBuilder(this)
                .append("productLine", productLine)
                .append("textDescription", textDescription)
                .append("products", products)
                .toString();
    }
}
