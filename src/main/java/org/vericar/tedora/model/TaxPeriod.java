package org.vericar.tedora.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class TaxPeriod {
    private String id;
    private short year;
    private short month;
    private LocalDate open;
    private LocalDate close;
    private boolean closed;
    private Long countPurchase;
    private Long countSales;

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
     * @return value of {@link #year}
     */
    @Basic
    @Column(name = "year")
    public short getYear() {
        return year;
    }

    /**
     * Public accessor - setter.
     *
     * @param year value to set into {@link #year}
     */
    public void setYear(short year) {
        this.year = year;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #month}
     */
    @Basic
    @Column(name = "month")
    public short getMonth() {
        return month;
    }

    /**
     * Public accessor - setter.
     *
     * @param month value to set into {@link #month}
     */
    public void setMonth(short month) {
        this.month = month;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #open}
     */
    @Basic
    @Column(name = "open")
    @Temporal(TemporalType.DATE)
    @Convert(converter = LocalDateEclipse.class)
    public LocalDate getOpen() {
        return open;
    }

    /**
     * Public accessor - setter.
     *
     * @param open value to set into {@link #open}
     */
    public void setOpen(LocalDate open) {
        this.open = open;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #close}
     */
    @Basic
    @Column(name = "close")
    @Temporal(TemporalType.DATE)
    @Convert(converter = LocalDateEclipse.class)
    public LocalDate getClose() {
        return close;
    }

    /**
     * Public accessor - setter.
     *
     * @param close value to set into {@link #close}
     */
    public void setClose(LocalDate close) {
        this.close = close;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #closed}
     */
    @Basic
    @Column(name = "closed")
    public boolean getClosed() {
        return closed;
    }

    /**
     * Public accessor - setter.
     *
     * @param closed value to set into {@link #closed}
     */
    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #countPurchase}
     */
    @Basic
    @Column(name = "countPurchase")
    public Long getCountPurchase() {
        return countPurchase;
    }

    /**
     * Public accessor - setter.
     *
     * @param countPurchase value to set into {@link #countPurchase}
     */
    public void setCountPurchase(Long countPurchase) {
        this.countPurchase = countPurchase;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #countSales}
     */
    @Basic
    @Column(name = "countSales")
    public Long getCountSales() {
        return countSales;
    }

    /**
     * Public accessor - setter.
     *
     * @param countSales value to set into {@link #countSales}
     */
    public void setCountSales(Long countSales) {
        this.countSales = countSales;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof TaxPeriod taxPeriod) {
            return year == taxPeriod.year && month == taxPeriod.month && closed == taxPeriod.closed && Objects.equals(id, taxPeriod.id) && Objects.equals(open, taxPeriod.open) && Objects.equals(close, taxPeriod.close) && Objects.equals(countPurchase, taxPeriod.countPurchase) && Objects.equals(countSales, taxPeriod.countSales);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, month, open, close, closed, countPurchase, countSales);
    }
}
