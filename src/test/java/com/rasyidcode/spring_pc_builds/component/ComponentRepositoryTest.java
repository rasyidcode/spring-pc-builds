package com.rasyidcode.spring_pc_builds.component;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@DataJdbcTest
public class ComponentRepositoryTest {

    @Autowired
    private ComponentRepository componentRepository;

    @Test
    public void test_findAllComponents() {
        List<Component> components = componentRepository.findAll();

        assertThat(components).isNotEmpty();
        assertThat(components.size()).isEqualTo(3);
        assertThat(components.getFirst().getId()).isEqualTo(1);
        assertThat(components.getFirst().getName()).isEqualTo("Ryzen 5 5600X");
        assertThat(components.getFirst().getType()).isEqualTo(ComponentType.CPU);
        assertThat(components.getFirst().getBrand()).isEqualTo("AMD");
        assertThat(components.getFirst().getModel()).isEqualTo("5600X");
        assertThat(components.getFirst().getSpecs()).isEqualTo("{\"cores\":6,\"threads\":12}");
        assertThat(components.getFirst().getPrice()).isEqualTo(299.99);
        assertThat(components.getFirst().getCreatedAt()).isInstanceOf(LocalDateTime.class);
        assertThat(components.getFirst().getCreatedAt()).isInstanceOf(LocalDateTime.class);
    }

    @Test
    public void test_findComponentById() {
        Optional<Component> optionalComponent = componentRepository.findById(1);

        assertThat(optionalComponent.isPresent()).isTrue();
        assertThat(optionalComponent.get().getName()).isEqualTo("Ryzen 5 5600X");
    }

    @Test
    public void test_findComponentById_returnNull() {
        Optional<Component> optionalComponent = componentRepository.findById(99);

        assertThat(optionalComponent.isEmpty()).isTrue();
    }

    @Test
    public void test_createComponent() {
        Component component = componentRepository.save(
                new Component(
                        "Intel Core i5-12600K",
                        ComponentType.CPU,
                        "Intel",
                        "12600K",
                        "{\"cores\": 10, \"threads\": 16, \"base_clock\": \"3.7GHz\", \"boost_clock\": \"4.9GHz\"}",
                        319.99)
        );

        assertThat(component.getId()).isEqualTo(4);
        assertThat(component.getName()).isEqualTo("Intel Core i5-12600K");
        assertThat(component.getType()).isEqualTo(ComponentType.CPU);
        assertThat(component.getPrice()).isEqualTo(319.99);
    }

    @Test
    public void test_updateComponent() {
        Optional<Component> optionalComponent = componentRepository.findById(1);
        optionalComponent.ifPresent((component) -> {
            component.setName("Radeon RX 6700 XT");
            component.setType(ComponentType.GPU);
            component.setBrand("AMD");
            component.setModel("6700 XT");
            component.setSpecs("{\"memory\": \"12GB GDDR6\", \"core_clock\": \"2321MHz\", \"boost_clock\": \"2581MHz\"}");
            component.setPrice(479.99);
            Component updatedComponent = componentRepository.save(component);

            assertThat(updatedComponent.getName()).isEqualTo("Radeon RX 6700 XT");
            assertThat(updatedComponent.getType()).isEqualTo(ComponentType.GPU);
            assertThat(updatedComponent.getBrand()).isEqualTo("AMD");
            assertThat(updatedComponent.getModel()).isEqualTo("6700 XT");
            assertThat(updatedComponent.getSpecs()).isEqualTo("{\"memory\": \"12GB GDDR6\", \"core_clock\": \"2321MHz\", \"boost_clock\": \"2581MHz\"}");
            assertThat(updatedComponent.getPrice()).isEqualTo(479.99);
        });
    }

    @Test
    public void test_deleteComponent() {
        componentRepository.deleteById(1);

        Optional<Component> deletedComponent = componentRepository.findById(1);

        assertThat(deletedComponent.isPresent()).isFalse();
    }

}
