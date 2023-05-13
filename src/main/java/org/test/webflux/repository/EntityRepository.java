package org.test.webflux.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.test.webflux.entity.EntityEntity;
import reactor.core.publisher.Flux;

public interface EntityRepository extends ReactiveCrudRepository<EntityEntity, Long> {
    String FIND_ALL_BY_USERNAME = """
            select e.id, e.user_id, e.name from entities e
                left join users u on e.user_id = u.id
                where u.login = :username
            """;

    @Query(FIND_ALL_BY_USERNAME)
    Flux<EntityEntity> findAllByUsername(String username);
}
