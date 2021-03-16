package org.vericar.tedora.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class DoiType {
    private String id;
    private String title;
    private boolean purchase;
    private boolean sale;
    private boolean foreign;
    private String regex;

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
     * @return value of {@link #regex}
     */
    @Basic
    @Column(name = "regex")
    public String getRegex() {
        return regex;
    }

    /**
     * Public accessor - setter.
     *
     * @param regex value to set into {@link #regex}
     */
    public void setRegex(String regex) {
        this.regex = regex;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof DoiType doiType) {
            return purchase == doiType.purchase && sale == doiType.sale && foreign == doiType.foreign && Objects.equals(id, doiType.id) && Objects.equals(title, doiType.title) && Objects.equals(regex, doiType.regex);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, purchase, sale, foreign, regex);
    }
}
