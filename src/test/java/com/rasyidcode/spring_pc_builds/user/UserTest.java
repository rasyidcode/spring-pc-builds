package com.rasyidcode.spring_pc_builds.user;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class UserTest {

    @Test
    public void test_createUserEntity() {
        User user = new User("dtrump", "12345", "dtrump@example.com");

        assertThat(user.getId()).isNull();
        assertThat(user.getUsername()).isEqualTo("dtrump");
        assertThat(user.getPassword()).isEqualTo("12345");
        assertThat(user.getEmail()).isEqualTo("dtrump@example.com");
    }

    @Test
    public void test_createUserEntityWithSetter() {
        User user = new User();
        user.setUsername("jbiden");
        user.setPassword("secret");
        user.setEmail("jbiden@example.com");

        assertThat(user.getId()).isNull();
        assertThat(user.getUsername()).isEqualTo("jbiden");
        assertThat(user.getPassword()).isEqualTo("secret");
        assertThat(user.getEmail()).isEqualTo("jbiden@example.com");
    }

}
