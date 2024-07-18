package com.rasyidcode.spring_pc_builds.build;

import com.rasyidcode.spring_pc_builds.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

public class BuildTest {

    @Test
    public void test_createBuildEntity() {
        User user = new User("user", "secret", "user@example.com");
        user.setId(1);
        Build build = new Build(AggregateReference.to(user.getId()), "Rakitan PC Kere Hore", "Cuma PC Kere Hore");
        LocalDateTime now = LocalDateTime.now();
        build.setCreatedAt(now);

        assertThat(build.getUserId().getId()).isEqualTo(user.getId());
        assertThat(build.getName()).isEqualTo("Rakitan PC Kere Hore");
        assertThat(build.getDescription()).isEqualTo("Cuma PC Kere Hore");
        assertThat(build.getCreatedAt()).isEqualTo(now);
    }

}
