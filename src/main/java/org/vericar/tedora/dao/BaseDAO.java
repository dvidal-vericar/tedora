package org.vericar.tedora.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * The base class for DAO implementations.
 *
 * @param <TPojo> type erasure of the domain model POJO.
 * @param <PK>    type erasure of the primary key of the POJO.
 * @param <TImpl> type ersure of specialized implementation.
 * @version 1.0
 */
public abstract class BaseDAO<
        TPojo,
        PK,
        TImpl extends BaseDAO<TPojo, PK, TImpl>> {

    /**
     * The entity manager factory.
     */
    private Supplier<EntityManager> em;
    /**
     * The item to insert/delete/update.
     */
    private TPojo item;

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #em}
     */
    protected Supplier<EntityManager> getEm() {
        return em;
    }

    /**
     * Fluent accessor - with.
     *
     * @param em value to set into {@link #em}
     * @return this instance.
     */
    public BaseDAO<TPojo, PK, TImpl> withEm(Supplier<EntityManager> em) {
        this.em = em;
        return this;
    }

    /**
     * Convenient method to work with a specific implementation.
     *
     * @return the specific and specialized implementation.
     */
    public abstract TImpl specialize();

    /**
     * Function to retrieve the ID from a TPojo instance.
     *
     * @return function to get the primary key ID from TPojo.
     */
    protected abstract Function<TPojo, PK> idExtractor();

    /**
     * The model domain class.
     *
     * @return the domain class.
     */
    protected abstract Class<TPojo> pojo();

    /**
     * Public accessor - getter.
     *
     * @return value of {@link #item}
     */
    public TPojo getItem() {
        return item;
    }

    /**
     * Fluent accessor - with.
     *
     * @param item value to set into {@link #item}
     * @return this instance.
     */
    public BaseDAO<TPojo, PK, TImpl> withItem(TPojo item) {
        this.item = item;
        return this;
    }

    /**
     * Inserts the item into the persistence context (and thus, database).
     *
     * @return the inserted item. If it has an autogenerated ID, will do that.
     */
    private TPojo hotInsert() {
        var _em = em.get();
        try {
            _em.getTransaction().begin();
            _em.persist(item);
            _em.getTransaction().commit();
            return item;
        } catch (RuntimeException e) {
            rollback(_em);
            throw e;
        }
    }

    /**
     * Creates a Mono to insert the {@link #item} into the database.
     *
     * @return the Mono ready to observe.
     */
    public Mono<TPojo> insert() {
        return Mono.fromCallable(this::hotInsert);
    }

    /**
     * Fetchs an item from its ID.
     *
     * @param id the item ID.
     * @return the item with given ID or null.
     */
    private TPojo hotFetch(PK id) {
        try {
            return em.get()
                    .getReference(
                            pojo(),
                            id);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    /**
     * Creates a Mono to retrieve a given item from
     * its primary key ID.
     *
     * @param id the given ID primary key.
     * @return a Mono ready to subscribe.
     */
    public Mono<TPojo> fetch(PK id) {
        return Mono.fromCallable(() -> hotFetch(id));
    }

    /**
     * String to list all elements in a single SELECT JPQL query.
     *
     * @return the "SELET T FROM **** T" text.
     */
    protected String listAllQuery() {
        return "SELECT T FROM %s T".formatted(pojo().getSimpleName());
    }

    /**
     * Lists all elements in the database.
     *
     * @return all elements from query in a Stream.
     */
    private Stream<TPojo> hotListAll() {
        return em.get()
                .createQuery(listAllQuery(), pojo())
                .getResultStream();
    }

    /**
     * Creates a Flux to list all elements of the database.
     *
     * @return the Flux ready to observe.
     */
    public Flux<TPojo> listAll() {
        return Flux.fromStream(this::hotListAll);
    }

    /**
     * Deletes the {@link #item}.
     *
     * @return the deleted item.
     */
    private TPojo hotDeleteOne() {
        var _em = em.get();
        try {
            _em.getTransaction().begin();
            _em.remove(item);
            _em.getTransaction().commit();
            return item;
        } catch (RuntimeException e) {
            rollback(_em);
            throw e;
        }
    }

    /**
     * Creates a Mono to delete one {@link #item}
     *
     * @return the Mono ready to observe.
     */
    public Mono<TPojo> deleteOne() {
        return Mono.fromCallable(this::hotDeleteOne);
    }

    /**
     * Updates one element in the database.
     *
     * @return the updated item.
     */
    private TPojo hotUpdate() {
        var _em = em.get();
        try {
            _em.getTransaction().begin();
            _em.merge(item);
            _em.getTransaction().commit();
            return item;
        } catch (RuntimeException e) {
            rollback(_em);
            throw e;
        }
    }

    /**
     * Creates a Mono to update the {@link #item}.
     *
     * @return Mono ready to observe. Will signal item.
     */
    public Mono<TPojo> update() {
        return Mono.fromSupplier(this::hotUpdate);
    }

    /**
     * Convenient method to check if there's an active
     * transaciton, and if so rollbacks.
     *
     * @param em the entity manager object.
     */
    private void rollback(EntityManager em) {
        var trx = em.getTransaction();
        if (trx.isActive()) trx.rollback();
    }
}
