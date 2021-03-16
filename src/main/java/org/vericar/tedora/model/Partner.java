package org.vericar.tedora.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Partner {
    private String id;
    private String doiNum;
    private String name;
    private String address;
    private String countryTaxId;
    private DoiType doiType;

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
     * @return value of {@link #doiNum}
     */
    @Basic
    @Column(name = "doiNum")
    public String getDoiNum() {
        return doiNum;
    }

    /**
     * Public accessor - setter.
     *
     * @param doiNum value to set into {@link #doiNum}
     */
    public void setDoiNum(String doiNum) {
        this.doiNum = doiNum;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #name}
     */
    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    /**
     * Public accessor - setter.
     *
     * @param name value to set into {@link #name}
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #address}
     */
    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    /**
     * Public accessor - setter.
     *
     * @param address value to set into {@link #address}
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #countryTaxId}
     */
    @Basic
    @Column(name = "countryTaxID")
    public String getCountryTaxId() {
        return countryTaxId;
    }

    /**
     * Public accessor - setter.
     *
     * @param countryTaxId value to set into {@link #countryTaxId}
     */
    public void setCountryTaxId(String countryTaxId) {
        this.countryTaxId = countryTaxId;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Partner partner) {
            return Objects.equals(id, partner.id) && Objects.equals(doiNum, partner.doiNum) && Objects.equals(name, partner.name) && Objects.equals(address, partner.address) && Objects.equals(countryTaxId, partner.countryTaxId);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, doiNum, name, address, countryTaxId);
    }

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #doiType}
     */
    @ManyToOne
    @JoinColumn(name = "doiType", referencedColumnName = "id", nullable = false)
    public DoiType getDoiType() {
        return doiType;
    }

    /**
     * Public accessor - setter.
     *
     * @param doiType value to set into {@link #doiType}
     */
    public void setDoiType(DoiType doiType) {
        this.doiType = doiType;
    }
}
