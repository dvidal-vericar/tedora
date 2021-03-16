package org.vericar.tedora.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Sale {
    private String id;
    private String correlative;
    private LocalDate dateIssue;
    private String folioSerie;
    private String folioNum;
    private BigDecimal priceFc;
    private BigDecimal taxFc;
    private BigDecimal discFc;
    private BigDecimal discTaxFc;
    private BigDecimal totalFc;
    private BigDecimal xrate;
    private Currencies currency;
    private BigDecimal priceSc;
    private BigDecimal taxSc;
    private BigDecimal discSc;
    private BigDecimal discTaxSc;
    private BigDecimal totalSc;
    private boolean voidFlag;
    private TaxPeriod period;
    private Partner partner;
    private FolioType folioType;
    private Sale modified;

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
     * @return value of {@link #correlative}
     */
    @Basic
    @Column(name = "correlative")
    public String getCorrelative() {
        return correlative;
    }

    /**
     * Public accessor - setter.
     *
     * @param correlative value to set into {@link #correlative}
     */
    public void setCorrelative(String correlative) {
        this.correlative = correlative;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #dateIssue}
     */
    @Basic
    @Column(name = "dateIssue")
    public LocalDate getDateIssue() {
        return dateIssue;
    }

    /**
     * Public accessor - setter.
     *
     * @param dateIssue value to set into {@link #dateIssue}
     */
    public void setDateIssue(LocalDate dateIssue) {
        this.dateIssue = dateIssue;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #folioSerie}
     */
    @Basic
    @Column(name = "folioSerie")
    public String getFolioSerie() {
        return folioSerie;
    }

    /**
     * Public accessor - setter.
     *
     * @param folioSerie value to set into {@link #folioSerie}
     */
    public void setFolioSerie(String folioSerie) {
        this.folioSerie = folioSerie;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #folioNum}
     */
    @Basic
    @Column(name = "folioNum")
    public String getFolioNum() {
        return folioNum;
    }

    /**
     * Public accessor - setter.
     *
     * @param folioNum value to set into {@link #folioNum}
     */
    public void setFolioNum(String folioNum) {
        this.folioNum = folioNum;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #priceFc}
     */
    @Basic
    @Column(name = "priceFC")
    public BigDecimal getPriceFc() {
        return priceFc;
    }

    /**
     * Public accessor - setter.
     *
     * @param priceFc value to set into {@link #priceFc}
     */
    public void setPriceFc(BigDecimal priceFc) {
        this.priceFc = priceFc;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #taxFc}
     */
    @Basic
    @Column(name = "taxFC")
    public BigDecimal getTaxFc() {
        return taxFc;
    }

    /**
     * Public accessor - setter.
     *
     * @param taxFc value to set into {@link #taxFc}
     */
    public void setTaxFc(BigDecimal taxFc) {
        this.taxFc = taxFc;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #discFc}
     */
    @Basic
    @Column(name = "discFC")
    public BigDecimal getDiscFc() {
        return discFc;
    }

    /**
     * Public accessor - setter.
     *
     * @param discFc value to set into {@link #discFc}
     */
    public void setDiscFc(BigDecimal discFc) {
        this.discFc = discFc;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #discTaxFc}
     */
    @Basic
    @Column(name = "discTaxFC")
    public BigDecimal getDiscTaxFc() {
        return discTaxFc;
    }

    /**
     * Public accessor - setter.
     *
     * @param discTaxFc value to set into {@link #discTaxFc}
     */
    public void setDiscTaxFc(BigDecimal discTaxFc) {
        this.discTaxFc = discTaxFc;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #totalFc}
     */
    @Basic
    @Column(name = "totalFC")
    public BigDecimal getTotalFc() {
        return totalFc;
    }

    /**
     * Public accessor - setter.
     *
     * @param totalFc value to set into {@link #totalFc}
     */
    public void setTotalFc(BigDecimal totalFc) {
        this.totalFc = totalFc;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #xrate}
     */
    @Basic
    @Column(name = "xrate")
    public BigDecimal getXrate() {
        return xrate;
    }

    /**
     * Public accessor - setter.
     *
     * @param xrate value to set into {@link #xrate}
     */
    public void setXrate(BigDecimal xrate) {
        this.xrate = xrate;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #currency}
     */
    @Basic
    @Column(name = "currency")
    public Currencies getCurrency() {
        return currency;
    }

    /**
     * Public accessor - setter.
     *
     * @param currency value to set into {@link #currency}
     */
    public void setCurrency(Currencies currency) {
        this.currency = currency;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #priceSc}
     */
    @Basic
    @Column(name = "priceSC")
    public BigDecimal getPriceSc() {
        return priceSc;
    }

    /**
     * Public accessor - setter.
     *
     * @param priceSc value to set into {@link #priceSc}
     */
    public void setPriceSc(BigDecimal priceSc) {
        this.priceSc = priceSc;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #taxSc}
     */
    @Basic
    @Column(name = "taxSC")
    public BigDecimal getTaxSc() {
        return taxSc;
    }

    /**
     * Public accessor - setter.
     *
     * @param taxSc value to set into {@link #taxSc}
     */
    public void setTaxSc(BigDecimal taxSc) {
        this.taxSc = taxSc;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #discSc}
     */
    @Basic
    @Column(name = "discSC")
    public BigDecimal getDiscSc() {
        return discSc;
    }

    /**
     * Public accessor - setter.
     *
     * @param discSc value to set into {@link #discSc}
     */
    public void setDiscSc(BigDecimal discSc) {
        this.discSc = discSc;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #discTaxSc}
     */
    @Basic
    @Column(name = "discTaxSC")
    public BigDecimal getDiscTaxSc() {
        return discTaxSc;
    }

    /**
     * Public accessor - setter.
     *
     * @param discTaxSc value to set into {@link #discTaxSc}
     */
    public void setDiscTaxSc(BigDecimal discTaxSc) {
        this.discTaxSc = discTaxSc;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #totalSc}
     */
    @Basic
    @Column(name = "totalSC")
    public BigDecimal getTotalSc() {
        return totalSc;
    }

    /**
     * Public accessor - setter.
     *
     * @param totalSc value to set into {@link #totalSc}
     */
    public void setTotalSc(BigDecimal totalSc) {
        this.totalSc = totalSc;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #voidFlag}
     */
    @Basic
    @Column(name = "voidFlag")
    public boolean getVoidFlag() {
        return voidFlag;
    }

    /**
     * Public accessor - setter.
     *
     * @param voidFlag value to set into {@link #voidFlag}
     */
    public void setVoidFlag(boolean voidFlag) {
        this.voidFlag = voidFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Sale sale) {
            return voidFlag == sale.voidFlag && Objects.equals(id, sale.id) && Objects.equals(correlative, sale.correlative) && Objects.equals(dateIssue, sale.dateIssue) && Objects.equals(folioSerie, sale.folioSerie) && Objects.equals(folioNum, sale.folioNum) && Objects.equals(priceFc, sale.priceFc) && Objects.equals(taxFc, sale.taxFc) && Objects.equals(discFc, sale.discFc) && Objects.equals(discTaxFc, sale.discTaxFc) && Objects.equals(totalFc, sale.totalFc) && Objects.equals(xrate, sale.xrate) && Objects.equals(currency, sale.currency) && Objects.equals(priceSc, sale.priceSc) && Objects.equals(taxSc, sale.taxSc) && Objects.equals(discSc, sale.discSc) && Objects.equals(discTaxSc, sale.discTaxSc) && Objects.equals(totalSc, sale.totalSc);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, correlative, dateIssue, folioSerie, folioNum, priceFc, taxFc, discFc, discTaxFc, totalFc, xrate, currency, priceSc, taxSc, discSc, discTaxSc, totalSc, voidFlag);
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #period}
     */
    @ManyToOne
    @JoinColumn(name = "period", referencedColumnName = "id", nullable = false)
    public TaxPeriod getPeriod() {
        return period;
    }

    /**
     * Public accessor - setter.
     *
     * @param period value to set into {@link #period}
     */
    public void setPeriod(TaxPeriod period) {
        this.period = period;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #partner}
     */
    @ManyToOne
    @JoinColumn(name = "partner", referencedColumnName = "id", nullable = false)
    public Partner getPartner() {
        return partner;
    }

    /**
     * Public accessor - setter.
     *
     * @param partner value to set into {@link #partner}
     */
    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #folioType}
     */
    @ManyToOne
    @JoinColumn(name = "folioType", referencedColumnName = "id", nullable = false)
    public FolioType getFolioType() {
        return folioType;
    }

    /**
     * Public accessor - setter.
     *
     * @param folioType value to set into {@link #folioType}
     */
    public void setFolioType(FolioType folioType) {
        this.folioType = folioType;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #modified}
     */
    @ManyToOne
    @JoinColumn(name = "modified", referencedColumnName = "id")
    public Sale getModified() {
        return modified;
    }

    /**
     * Public accessor - setter.
     *
     * @param modified value to set into {@link #modified}
     */
    public void setModified(Sale modified) {
        this.modified = modified;
    }
}
