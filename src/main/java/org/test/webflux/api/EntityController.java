package org.test.webflux.api;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.test.webflux.entity.EntityEntity;
import org.test.webflux.service.interfaces.EntityService;
import reactor.core.publisher.Flux;

import java.security.Principal;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EntityController {

    private final EntityService entityService;

    @GetMapping("/user/entities")
    public Flux<EntityEntity> getEntitiesByUsername(Principal principal) {
        String name = principal.getName();
        return entityService.getAllEntitiesByUsername(name);
    }
}
