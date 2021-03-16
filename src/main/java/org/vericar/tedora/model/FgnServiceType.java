package org.vericar.tedora.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class FgnServiceType {
    private String id;
    private String description;

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
     * @return value of {@link #description}
     */
    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    /**
     * Public accessor - setter.
     *
     * @param description value to set into {@link #description}
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof FgnServiceType that) {
            return Objects.equals(id, that.id) && Objects.equals(description, that.description);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }
}
