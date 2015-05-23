package edu.uw.data.lecture8.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by credmond on 26/03/15.
 */
@Entity
@Table(name = "OFFICE_TYPES")
public class OfficeType implements Serializable {
  private Integer officeType;
  private String description;



    @Id
  @Column(name = "OFFICE_TYPE" )
    public Integer getOfficeType() {
        return officeType;
    }

    public void setOfficeType(Integer officeType) {
        this.officeType = officeType;
    }


    @Basic
  @Column(name = "DESCRIPTION" )

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
        return new ToStringBuilder(this)
                .append("officeType", officeType)
                .append("description", description)
                .toString();
    }
}
