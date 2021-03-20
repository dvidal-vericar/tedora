/**
 * Tedora application module.
 *
 * @author David Vidal
 */
module tedora {

    //Jakarta JPA
    requires jakarta.persistence;
    requires eclipselink;
    requires org.mariadb.jdbc;

    //Reactor
    requires reactor.core;

    //Exports directive
    exports org.vericar.tedora.model;
}
