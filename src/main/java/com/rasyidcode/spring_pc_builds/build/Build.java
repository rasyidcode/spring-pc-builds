package com.rasyidcode.spring_pc_builds.build;

import com.rasyidcode.spring_pc_builds.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Table("builds")
public class Build {

    @Id
    private Integer id;

    private AggregateReference<User, Integer> userId;

    private String name;

    private String description;

    @Column("created_at")
    private LocalDateTime createdAt;

    public Build(AggregateReference<User, Integer> userId, String name, String description) {
        this.userId = userId;
        this.name = name;
        this.description = description;
    }

}
