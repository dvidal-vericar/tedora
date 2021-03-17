package org.vericar.tedora.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Purchase {
    private String id;
    private String correlative;
    private LocalDate dateIssue;
    private LocalDate dateDue;
    private String folioSerie;
    private String folioNum;
    private BigDecimal priceFc;
    private BigDecimal taxFc;
    private BigDecimal taxFreeFc;
    private BigDecimal icbpFc;
    private BigDecimal othFc;
    private BigDecimal totalFc;
    private BigDecimal xrate;
    private Currencies currency;
    private BigDecimal priceSc;
    private BigDecimal taxSc;
    private BigDecimal taxFreeSc;
    private BigDecimal icbpSc;
    private BigDecimal othSc;
    private BigDecimal totalSc;
    private byte voidFlag;
    private String spotId;
    private LocalDate spotDate;
    private TaxPeriod period;
    private Partner partner;
    private FolioType folioType;
    private Purchase modified;

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
    @Temporal(TemporalType.DATE)
    @Convert(converter = LocalDateEclipse.class)
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
     * @return value of {@link #dateDue}
     */
    @Basic
    @Column(name = "dateDue")
    @Temporal(TemporalType.DATE)
    @Convert(converter = LocalDateEclipse.class)
    public LocalDate getDateDue() {
        return dateDue;
    }

    /**
     * Public accessor - setter.
     *
     * @param dateDue value to set into {@link #dateDue}
     */
    public void setDateDue(LocalDate dateDue) {
        this.dateDue = dateDue;
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
     * @return value of {@link #taxFreeFc}
     */
    @Basic
    @Column(name = "taxFreeFC")
    public BigDecimal getTaxFreeFc() {
        return taxFreeFc;
    }

    /**
     * Public accessor - setter.
     *
     * @param taxFreeFc value to set into {@link #taxFreeFc}
     */
    public void setTaxFreeFc(BigDecimal taxFreeFc) {
        this.taxFreeFc = taxFreeFc;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #icbpFc}
     */
    @Basic
    @Column(name = "icbpFC")
    public BigDecimal getIcbpFc() {
        return icbpFc;
    }

    /**
     * Public accessor - setter.
     *
     * @param icbpFc value to set into {@link #icbpFc}
     */
    public void setIcbpFc(BigDecimal icbpFc) {
        this.icbpFc = icbpFc;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #othFc}
     */
    @Basic
    @Column(name = "othFC")
    public BigDecimal getOthFc() {
        return othFc;
    }

    /**
     * Public accessor - setter.
     *
     * @param othFc value to set into {@link #othFc}
     */
    public void setOthFc(BigDecimal othFc) {
        this.othFc = othFc;
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
     * @return value of {@link #taxFreeSc}
     */
    @Basic
    @Column(name = "taxFreeSC")
    public BigDecimal getTaxFreeSc() {
        return taxFreeSc;
    }

    /**
     * Public accessor - setter.
     *
     * @param taxFreeSc value to set into {@link #taxFreeSc}
     */
    public void setTaxFreeSc(BigDecimal taxFreeSc) {
        this.taxFreeSc = taxFreeSc;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #icbpSc}
     */
    @Basic
    @Column(name = "icbpSC")
    public BigDecimal getIcbpSc() {
        return icbpSc;
    }

    /**
     * Public accessor - setter.
     *
     * @param icbpSc value to set into {@link #icbpSc}
     */
    public void setIcbpSc(BigDecimal icbpSc) {
        this.icbpSc = icbpSc;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #othSc}
     */
    @Basic
    @Column(name = "othSC")
    public BigDecimal getOthSc() {
        return othSc;
    }

    /**
     * Public accessor - setter.
     *
     * @param othSc value to set into {@link #othSc}
     */
    public void setOthSc(BigDecimal othSc) {
        this.othSc = othSc;
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
    public byte getVoidFlag() {
        return voidFlag;
    }

    /**
     * Public accessor - setter.
     *
     * @param voidFlag value to set into {@link #voidFlag}
     */
    public void setVoidFlag(byte voidFlag) {
        this.voidFlag = voidFlag;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #spotId}
     */
    @Basic
    @Column(name = "spotID")
    public String getSpotId() {
        return spotId;
    }

    /**
     * Public accessor - setter.
     *
     * @param spotId value to set into {@link #spotId}
     */
    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #spotDate}
     */
    @Basic
    @Column(name = "spotDate")
    @Temporal(TemporalType.DATE)
    @Convert(converter = LocalDateEclipse.class)
    public LocalDate getSpotDate() {
        return spotDate;
    }

    /**
     * Public accessor - setter.
     *
     * @param spotDate value to set into {@link #spotDate}
     */
    public void setSpotDate(LocalDate spotDate) {
        this.spotDate = spotDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Purchase purchase) {
            return voidFlag == purchase.voidFlag && Objects.equals(id, purchase.id) && Objects.equals(correlative, purchase.correlative) && Objects.equals(dateIssue, purchase.dateIssue) && Objects.equals(dateDue, purchase.dateDue) && Objects.equals(folioSerie, purchase.folioSerie) && Objects.equals(folioNum, purchase.folioNum) && Objects.equals(priceFc, purchase.priceFc) && Objects.equals(taxFc, purchase.taxFc) && Objects.equals(taxFreeFc, purchase.taxFreeFc) && Objects.equals(icbpFc, purchase.icbpFc) && Objects.equals(othFc, purchase.othFc) && Objects.equals(totalFc, purchase.totalFc) && Objects.equals(xrate, purchase.xrate) && Objects.equals(currency, purchase.currency) && Objects.equals(priceSc, purchase.priceSc) && Objects.equals(taxSc, purchase.taxSc) && Objects.equals(taxFreeSc, purchase.taxFreeSc) && Objects.equals(icbpSc, purchase.icbpSc) && Objects.equals(othSc, purchase.othSc) && Objects.equals(totalSc, purchase.totalSc) && Objects.equals(spotId, purchase.spotId) && Objects.equals(spotDate, purchase.spotDate);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, correlative, dateIssue, dateDue, folioSerie, folioNum, priceFc, taxFc, taxFreeFc, icbpFc, othFc, totalFc, xrate, currency, priceSc, taxSc, taxFreeSc, icbpSc, othSc, totalSc, voidFlag, spotId, spotDate);
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
    public Purchase getModified() {
        return modified;
    }

    /**
     * Public accessor - setter.
     *
     * @param modified value to set into {@link #modified}
     */
    public void setModified(Purchase modified) {
        this.modified = modified;
    }
}
