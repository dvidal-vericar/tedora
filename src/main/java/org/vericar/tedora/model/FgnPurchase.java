package org.vericar.tedora.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class FgnPurchase {
    private String id;
    private String correlative;
    private LocalDate dateIssue;
    private String folioSerie;
    private String folioNum;
    private BigDecimal priceFc;
    private BigDecimal othFc;
    private BigDecimal totalFc;
    private BigDecimal taxFc;
    private BigDecimal incomeTaxRate;
    private BigDecimal incomeTaxFc;
    private BigDecimal priceSc;
    private BigDecimal othSc;
    private BigDecimal totalSc;
    private BigDecimal taxSc;
    private BigDecimal incomeTaxSc;
    private Currencies currency;
    private BigDecimal xrate;
    private byte provision76;
    private TaxPeriod period;
    private FolioType folioType;
    private Purchase taxFolio;
    private FgnIncomeType incomeType;
    private FgnServiceType serviceType;
    private Partner partner;

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

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #incomeTaxFc}
     */
    @Basic
    @Column(name = "incomeTaxFC")
    public BigDecimal getIncomeTaxFc() {
        return incomeTaxFc;
    }

    /**
     * Public accessor - setter.
     *
     * @param incomeTaxFc value to set into {@link #incomeTaxFc}
     */
    public void setIncomeTaxFc(BigDecimal incomeTaxFc) {
        this.incomeTaxFc = incomeTaxFc;
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
     * @return value of {@link #incomeTaxSc}
     */
    @Basic
    @Column(name = "incomeTaxSC")
    public BigDecimal getIncomeTaxSc() {
        return incomeTaxSc;
    }

    /**
     * Public accessor - setter.
     *
     * @param incomeTaxSc value to set into {@link #incomeTaxSc}
     */
    public void setIncomeTaxSc(BigDecimal incomeTaxSc) {
        this.incomeTaxSc = incomeTaxSc;
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
     * @return value of {@link #provision76}
     */
    @Basic
    @Column(name = "provision76")
    public byte getProvision76() {
        return provision76;
    }

    /**
     * Public accessor - setter.
     *
     * @param provision76 value to set into {@link #provision76}
     */
    public void setProvision76(byte provision76) {
        this.provision76 = provision76;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof FgnPurchase that) {
            return provision76 == that.provision76 && Objects.equals(id, that.id) && Objects.equals(correlative, that.correlative) && Objects.equals(dateIssue, that.dateIssue) && Objects.equals(folioSerie, that.folioSerie) && Objects.equals(folioNum, that.folioNum) && Objects.equals(priceFc, that.priceFc) && Objects.equals(othFc, that.othFc) && Objects.equals(totalFc, that.totalFc) && Objects.equals(taxFc, that.taxFc) && Objects.equals(incomeTaxRate, that.incomeTaxRate) && Objects.equals(incomeTaxFc, that.incomeTaxFc) && Objects.equals(priceSc, that.priceSc) && Objects.equals(othSc, that.othSc) && Objects.equals(totalSc, that.totalSc) && Objects.equals(taxSc, that.taxSc) && Objects.equals(incomeTaxSc, that.incomeTaxSc) && Objects.equals(currency, that.currency) && Objects.equals(xrate, that.xrate);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, correlative, dateIssue, folioSerie, folioNum, priceFc, othFc, totalFc, taxFc, incomeTaxRate, incomeTaxFc, priceSc, othSc, totalSc, taxSc, incomeTaxSc, currency, xrate, provision76);
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
     * @return value of {@link #taxFolio}
     */
    @ManyToOne
    @JoinColumn(name = "taxFolio", referencedColumnName = "id", nullable = false)
    public Purchase getTaxFolio() {
        return taxFolio;
    }

    /**
     * Public accessor - setter.
     *
     * @param taxFolio value to set into {@link #taxFolio}
     */
    public void setTaxFolio(Purchase taxFolio) {
        this.taxFolio = taxFolio;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #incomeType}
     */
    @ManyToOne
    @JoinColumn(name = "incomeType", referencedColumnName = "id", nullable = false)
    public FgnIncomeType getIncomeType() {
        return incomeType;
    }

    /**
     * Public accessor - setter.
     *
     * @param incomeType value to set into {@link #incomeType}
     */
    public void setIncomeType(FgnIncomeType incomeType) {
        this.incomeType = incomeType;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #serviceType}
     */
    @ManyToOne
    @JoinColumn(name = "serviceType", referencedColumnName = "id", nullable = false)
    public FgnServiceType getServiceType() {
        return serviceType;
    }

    /**
     * Public accessor - setter.
     *
     * @param serviceType value to set into {@link #serviceType}
     */
    public void setServiceType(FgnServiceType serviceType) {
        this.serviceType = serviceType;
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
}
