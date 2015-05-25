package edu.uw.data.lecture8.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by credmond on 26/03/15.
 */


public class OfficeType implements Serializable {
  private Integer officeType;
  private String description;


    public OfficeType() {

    }

    public OfficeType(Integer officeType) {
        this.officeType = officeType;
    }

    public Integer getOfficeType() {
        return officeType;
    }

    public void setOfficeType(Integer officeType) {
        this.officeType = officeType;
    }





    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OfficeType)) return false;
        OfficeType that = (OfficeType) o;
        return Objects.equals(officeType, that.officeType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(officeType);
    }

    @Override
    public String toString() {
        ToStringBuilder.setDefaultStyle(ToStringStyle.MULTI_LINE_STYLE);
        return new ToStringBuilder(this)
                .append("officeType", officeType)
                .append("description", description)
                .toString();
    }
}
