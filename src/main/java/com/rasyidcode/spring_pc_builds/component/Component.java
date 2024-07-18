package com.rasyidcode.spring_pc_builds.component;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Table("components")
public class Component {

    @Id
    @Column("id")
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column("name")
    private String name;

    @Column("type")
    private ComponentType type;

    @Column("brand")
    private String brand;

    @Column("model")
    private String model;

    @Column("specs")
    private String specs;

    @Column("price")
    private Double price;

    @Column("created_at")
    @Setter(AccessLevel.NONE)
    private LocalDateTime createdAt;

    @Column("updated_at")
    @Setter(AccessLevel.NONE)
    private LocalDateTime updatedAt;

    public Component(String name, ComponentType type, String brand, String model, String specs, Double price) {
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.specs = specs;
        this.price = price;
    }

}
