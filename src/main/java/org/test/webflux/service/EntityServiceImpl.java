package org.test.webflux.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.test.webflux.entity.EntityEntity;
import org.test.webflux.repository.EntityRepository;
import org.test.webflux.service.interfaces.EntityService;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class EntityServiceImpl implements EntityService {

    private final EntityRepository entityRepository;

    @Override
    public Flux<EntityEntity> getAllEntitiesByUsername(String username) {
        return entityRepository.findAllByUsername(username);
    }
}
