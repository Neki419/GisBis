package org.test.webflux.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("entity")
public class EntityEntity {

    @Id
    private Long id;
    private String name;
    private Long userId;

}
