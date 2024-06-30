package com.rasyidcode.spring_pc_builds.type;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@Table("types")
public class Type {

    @Id
    @Column("id")
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column("name")
    private String name;

    public Type(String name) {
        this.name = name;
    }

}
