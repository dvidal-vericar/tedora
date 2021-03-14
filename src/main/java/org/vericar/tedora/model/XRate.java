package org.vericar.tedora.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * This element represents a currency eXchange Rate.
 * Since this app is for taxation purposes in Peru, and
 * only manage a local currency (PEN) and a foreign currency (USD),
 * then the exchange rate currency is not significative for the app scope.
 * Also, peruvian taxation rules states two exchange rates, one is the
 * purchase rate and the other the sale rate. The purchase rates are used
 * when the company buys something; while the sale rate when the company
 * sells something. Those rates are periodically published by the SUNAT (taxation
 * authority) and the SBS (bank regulator). Those may be found in
 * <a href="https://e-consulta.sunat.gob.pe/cl-at-ittipcam/tcS01Alias">
 * SUNAT tipo de cambio</a> microsite.
 * <br>
 * Or, in the <a href="https://www.sbs.gob.pe/app/pp/seriesHistoricas2/paso1.aspx">
 * SBS statistical app.</a>
 * <p>
 * We have downloaded all the historical xrates from april 1st, 2019 and using LibreOffice calc
 * created all the records needed to fill the database in csv format. This file, may be found
 * in the "external" directory of the project, in the xrates.csv file.
 *
 * @version 1.0
 */
public class XRate {
    /**
     * The date in which this xRate is effective.
     */
    private LocalDate date;
    /**
     * The purchase rate.
     */
    private BigDecimal purchase;
    /**
     * The sale rate.
     */
    private BigDecimal sale;

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #date}
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Public accessor - setter.
     *
     * @param date value to set into {@link #date}
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #purchase}
     */
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
            return Objects.equals(getDate(), xRate.getDate());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate());
    }
}
