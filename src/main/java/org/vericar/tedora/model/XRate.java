package org.vericar.tedora.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class XRate {
    private String id;
    private LocalDate taxDate;
    private BigDecimal purchase;
    private BigDecimal sale;

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
     * @return value of {@link #taxDate}
     */
    @Basic
    @Column(name = "taxDate")
    @Temporal(TemporalType.DATE)
    @Convert(converter = LocalDateEclipse.class)
    public LocalDate getTaxDate() {
        return taxDate;
    }

    /**
     * Public accessor - setter.
     *
     * @param taxDate value to set into {@link #taxDate}
     */
    public void setTaxDate(LocalDate taxDate) {
        this.taxDate = taxDate;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #purchase}
     */
    @Basic
    @Column(name = "purchase")
    public BigDecimal getPurchase() {
        return purchase;
    }

    /**
     * Public accessor - setter.
     *
     * @param purchase value to set into {@link #purchase}
     */
    public void setPurchase(BigDecimal purchase) {
        this.purchase = purchase;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #sale}
     */
    @Basic
    @Column(name = "sale")
    public BigDecimal getSale() {
        return sale;
    }

    /**
     * Public accessor - setter.
     *
     * @param sale value to set into {@link #sale}
     */
    public void setSale(BigDecimal sale) {
        this.sale = sale;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof XRate xRate) {
            return Objects.equals(id, xRate.id) && Objects.equals(taxDate, xRate.taxDate) && Objects.equals(purchase, xRate.purchase) && Objects.equals(sale, xRate.sale);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taxDate, purchase, sale);
    }
}
