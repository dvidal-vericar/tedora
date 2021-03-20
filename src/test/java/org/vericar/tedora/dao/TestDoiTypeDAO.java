package org.vericar.tedora.dao;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import java.time.Duration;

class TestDoiTypeDAO {
    @Test
    void testListAll() {
        var em = DataSourceBuilder.test().build();
        var flux = DAOFactory.factory(em).doiType().listAll();
        StepVerifier.create(flux)
                .expectSubscription()
                .thenRequest(Long.MAX_VALUE)
                .consumeNextWith(p -> System.out.printf("%s : %s.%n", p.getId(), p.getTitle()))
                .expectComplete()
                .verifyThenAssertThat()
                .tookLessThan(Duration.ofSeconds(30));
    }

}
