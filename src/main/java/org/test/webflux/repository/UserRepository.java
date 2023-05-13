package org.test.webflux.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.test.webflux.entity.UserEntity;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<UserEntity, Long> {

    Mono<UserEntity> findByLogin(String login);
}
