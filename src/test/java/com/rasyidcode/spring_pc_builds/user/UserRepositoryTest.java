package com.rasyidcode.spring_pc_builds.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DataJdbcTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test_getUsers() {
        List<User> users = userRepository.findAll();

        assertThat(users).isNotEmpty();
        assertThat(users.size()).isEqualTo(3);
        assertThat(users.getFirst().getId()).isEqualTo(1);
        assertThat(users.getFirst().getUsername()).isEqualTo("dtrump");
        assertThat(users.getFirst().getPassword()).isEqualTo("12345");
        assertThat(users.getFirst().getEmail()).isEqualTo("dtrump@example.com");
    }

    @Test
    public void test_getUserById() {

    }

    @Test
    public void test_getUserById_returnsNull() {

    }

    @Test
    public void test_createUser() {

    }

    @Test
    public void test_createUserWithDuplicateUsername_throwsException() {

    }

    @Test
    public void test_createUserWithDuplicateEmail_throwsException() {

    }

    @Test
    public void test_updateUser() {

    }

    @Test
    public void test_deleteUser() {

    }

}
