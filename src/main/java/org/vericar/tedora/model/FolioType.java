package org.vericar.tedora.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class FolioType {
    private String id;
    private String title;
    private boolean purchase;
    private boolean sale;
    private boolean foreign;
    private boolean allowDueDate;
    private String regexSerie;
    private String regexNum;
    private boolean taxable;
    private String serieTooltip;

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
     * @return value of {@link #title}
     */
    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    /**
     * Public accessor - setter.
     *
     * @param title value to set into {@link #title}
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #purchase}
     */
    @Basic
    @Column(name = "purchase")
    public boolean getPurchase() {
        return purchase;
    }

    /**
     * Public accessor - setter.
     *
     * @param purchase value to set into {@link #purchase}
     */
    public void setPurchase(boolean purchase) {
        this.purchase = purchase;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #sale}
     */
    @Basic
    @Column(name = "sale")
    public boolean getSale() {
        return sale;
    }

    /**
     * Public accessor - setter.
     *
     * @param sale value to set into {@link #sale}
     */
    public void setSale(boolean sale) {
        this.sale = sale;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #foreign}
     */
    @Basic
    @Column(name = "foreign")
    public boolean getForeign() {
        return foreign;
    }

    /**
     * Public accessor - setter.
     *
     * @param foreign value to set into {@link #foreign}
     */
    public void setForeign(boolean foreign) {
        this.foreign = foreign;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #allowDueDate}
     */
    @Basic
    @Column(name = "allowDueDate")
    public boolean getAllowDueDate() {
        return allowDueDate;
    }

    /**
     * Public accessor - setter.
     *
     * @param allowDueDate value to set into {@link #allowDueDate}
     */
    public void setAllowDueDate(boolean allowDueDate) {
        this.allowDueDate = allowDueDate;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #regexSerie}
     */
    @Basic
    @Column(name = "regexSerie")
    public String getRegexSerie() {
        return regexSerie;
    }

    /**
     * Public accessor - setter.
     *
     * @param regexSerie value to set into {@link #regexSerie}
     */
    public void setRegexSerie(String regexSerie) {
        this.regexSerie = regexSerie;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #regexNum}
     */
    @Basic
    @Column(name = "regexNum")
    public String getRegexNum() {
        return regexNum;
    }

    /**
     * Public accessor - setter.
     *
     * @param regexNum value to set into {@link #regexNum}
     */
    public void setRegexNum(String regexNum) {
        this.regexNum = regexNum;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #taxable}
     */
    @Basic
    @Column(name = "taxable")
    public boolean getTaxable() {
        return taxable;
    }

    /**
     * Public accessor - setter.
     *
     * @param taxable value to set into {@link #taxable}
     */
    public void setTaxable(boolean taxable) {
        this.taxable = taxable;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #serieTooltip}
     */
    @Basic
    @Column(name = "serieTooltip")
    public String getSerieTooltip() {
        return serieTooltip;
    }

    /**
     * Public accessor - setter.
     *
     * @param serieTooltip value to set into {@link #serieTooltip}
     */
    public void setSerieTooltip(String serieTooltip) {
        this.serieTooltip = serieTooltip;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof FolioType folioType) {
            return purchase == folioType.purchase && sale == folioType.sale && foreign == folioType.foreign && allowDueDate == folioType.allowDueDate && taxable == folioType.taxable && Objects.equals(id, folioType.id) && Objects.equals(title, folioType.title) && Objects.equals(regexSerie, folioType.regexSerie) && Objects.equals(regexNum, folioType.regexNum) && Objects.equals(serieTooltip, folioType.serieTooltip);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, purchase, sale, foreign, allowDueDate, regexSerie, regexNum, taxable, serieTooltip);
    }
}
