package org.vericar.tedora.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class FgnIncomeType {
    private String id;
    private String shortName;
    private BigDecimal incomeTaxRate;

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #id}
     */
    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    /**
     * Public accessor - setter.
     *
     * @param id value to set into {@link #id}
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #shortName}
     */
    @Basic
    @Column(name = "shortName")
    public String getShortName() {
        return shortName;
    }

    /**
     * Public accessor - setter.
     *
     * @param shortName value to set into {@link #shortName}
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #incomeTaxRate}
     */
    @Basic
    @Column(name = "incomeTaxRate")
    public BigDecimal getIncomeTaxRate() {
        return incomeTaxRate;
    }

    /**
     * Public accessor - setter.
     *
     * @param incomeTaxRate value to set into {@link #incomeTaxRate}
     */
    public void setIncomeTaxRate(BigDecimal incomeTaxRate) {
        this.incomeTaxRate = incomeTaxRate;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof FgnIncomeType that) {
            return Objects.equals(id, that.id) && Objects.equals(shortName, that.shortName) && Objects.equals(incomeTaxRate, that.incomeTaxRate);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shortName, incomeTaxRate);
    }
}
