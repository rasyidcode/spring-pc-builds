package com.rasyidcode.spring_pc_builds.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.Optional;

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
        Optional<User> optionalUser = userRepository.findById(1);

        assertThat(optionalUser.isPresent()).isTrue();
    }

    @Test
    public void test_getUserById_returnsNull() {
        Optional<User> optionalUser = userRepository.findById(5);

        assertThat(optionalUser.isPresent()).isFalse();
    }

    @Test
    public void test_createUser() {
        User createdUser = userRepository.save(
                new User(
                        "gbush",
                        "12345",
                        "gbush@example.com")
        );

        assertThat(createdUser.getUsername()).isEqualTo("gbush");
        assertThat(createdUser.getPassword()).isEqualTo("12345");
        assertThat(createdUser.getEmail()).isEqualTo("gbush@example.com");
    }

    @Test
    public void test_createUserWithDuplicateUsername_throwsException() {
        assertThatThrownBy(() ->
                userRepository.save(
                        new User(
                                "dtrump",
                                "12345",
                                "dtrumpp@example.com")
                )
        ).hasCauseInstanceOf(DataIntegrityViolationException.class);
    }

    @Test
    public void test_createUserWithDuplicateEmail_throwsException() {
        assertThatThrownBy(() -> userRepository.save(
                new User(
                        "dtrumpp",
                        "12345",
                        "dtrump@example.com"
                )
        )).hasCauseInstanceOf(DataIntegrityViolationException.class);
    }

    @Test
    public void test_updateUser() {
        Optional<User> optionalUser = userRepository.findById(1);
        optionalUser.ifPresent((user) -> {
            user.setUsername("dtrumpp");
            user.setPassword("secret");
            user.setEmail("dtrumpp@example.com");

            User updatedUser = userRepository.save(user);

            assertThat(updatedUser.getUsername()).isEqualTo("dtrumpp");
            assertThat(updatedUser.getPassword()).isEqualTo("secret");
            assertThat(updatedUser.getEmail()).isEqualTo("dtrumpp@example.com");
        });
    }

    @Test
    public void test_deleteUser() {
        userRepository.deleteById(1);

        Optional<User> optionalUser = userRepository.findById(1);

        assertThat(optionalUser.isPresent()).isFalse();
    }

}
