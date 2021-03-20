package org.vericar.tedora.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * Builder for DataSource as a supplier.
 *
 * @author David Vidal Escudero
 * @version 1.0
 * @since beta
 */
public class DataSourceBuilder {
    /**
     * The persistence unit name.
     */
    private String pUnit;

    /**
     * Creates a builder for testing purposes.
     *
     * @return new builder for test PU.
     */
    public static DataSourceBuilder test() {
        return new DataSourceBuilder().withPUnit("tedoraPU_test");
    }

    /**
     * Fluent setter - with.
     *
     * @param pUnit new value to set in {@link #pUnit}
     * @return this instance.
     */
    public final DataSourceBuilder withPUnit(String pUnit) {
        this.pUnit = pUnit;
        return this;
    }

    /**
     * Creates an entity manager factory wrapped as a supplier.
     *
     * @return built supplier.
     */
    public Supplier<EntityManager> build() {
        return new DelegatedSupplier();
    }

    /**
     * Delegated implementation to create entity manager factories.
     * Also extends Thread, so when Runtime shuts down, any EntityManagerFactory
     * or EntityManager created by this impl, will be closed.
     *
     * @version 1.0
     */
    private class DelegatedSupplier extends Thread
            implements Supplier<EntityManager> {
        /**
         * The entity manager factory.
         */
        private final EntityManagerFactory emf =
                Persistence.createEntityManagerFactory(pUnit);
        /**
         * The entity manager.
         */
        private EntityManager em;

        /**
         * Supplier that adds a shutdown hook to close {@link #em} and {@link #emf}
         */
        private DelegatedSupplier() {
            Runtime.getRuntime().addShutdownHook(this);
        }

        @Override
        public EntityManager get() {
            em = Objects.requireNonNullElseGet(em, emf::createEntityManager);
            return em;
        }

        @Override
        public void run() {
            if (em != null && em.isOpen()) em.close();
            if (emf != null && emf.isOpen()) emf.close();
        }
    }
}
