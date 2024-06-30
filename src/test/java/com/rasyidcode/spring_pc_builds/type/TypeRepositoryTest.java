package com.rasyidcode.spring_pc_builds.type;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@DataJdbcTest
public class TypeRepositoryTest {

    @Autowired
    private TypeRepository typeRepository;

    @Test
    public void test_getTypes() {
        List<Type> types = typeRepository.findAll();

        assertThat(types).isNotEmpty();
        assertThat(types.size()).isEqualTo(5);
        assertThat(types.getFirst().getName()).isEqualTo("CPU");
    }

    @Test
    public void test_getTypeById() {
        Optional<Type> type = typeRepository.findById(1);

        assertThat(type.isPresent()).isTrue();
    }

    @Test
    public void test_createType() {
        Type type = typeRepository.save(
                new Type("Keyboard")
        );

        assertThat(type.getId()).isEqualTo(6);
        assertThat(type.getName()).isEqualTo("Keyboard");
    }

    @Test
    public void test_updateType() {
        Optional<Type> optionalType = typeRepository.findById(1);
        optionalType.ifPresent((type) -> {
            type.setName("Monitor");

            Type updatedType = typeRepository.save(type);

            assertThat(updatedType.getName()).isEqualTo("Monitor");
        });
    }

    @Test
    public void test_deleteTypeById() {
        typeRepository.deleteById(1);

        Optional<Type> type = typeRepository.findById(1);

        assertThat(type.isPresent()).isFalse();
    }

}
