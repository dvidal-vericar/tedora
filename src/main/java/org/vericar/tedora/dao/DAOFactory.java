package org.vericar.tedora.dao;

import jakarta.persistence.EntityManager;
import org.vericar.tedora.model.DoiType;

import java.util.function.Supplier;

/**
 * Factory of DAO.
 *
 * @version 1.0
 */
public class DAOFactory {
    /**
     * The entity manager factory.
     */
    private Supplier<EntityManager> em;

    /**
     * Utility instanciation.
     *
     * @param em the entity manager factory.
     * @return a new factory.
     */
    public static DAOFactory factory(Supplier<EntityManager> em) {
        return new DAOFactory().withEm(em);
    }

    /**
     * Fluent setter - with.
     *
     * @param em new value to set in {@link #em}
     * @return this instance.
     */
    public final DAOFactory withEm(Supplier<EntityManager> em) {
        this.em = em;
        return this;
    }

    /**
     * Creates a DoiType dao instance.
     *
     * @return dao object.
     */
    public BaseDAO<DoiType, String, DoiTypeDAO> doiType() {
        return new DoiTypeDAO().withEm(em);
    }
}
