package org.test.webflux.service.interfaces;

import org.test.webflux.entity.EntityEntity;
import reactor.core.publisher.Flux;

public interface EntityService {

    Flux<EntityEntity> getAllEntitiesByUsername(String username);
}
