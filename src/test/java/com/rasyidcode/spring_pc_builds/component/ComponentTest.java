package com.rasyidcode.spring_pc_builds.component;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ComponentTest {

    @Test
    public void test_createComponentAndCheckValues() {
        Component component = new Component(
                "Ryzen 5 5600X",
                ComponentType.CPU,
                "AMD",
                "5600X",
                "{\"cores\": 6, \"threads\": 12, \"base_clock\": \"3.7GHz\", \"boost_clock\": \"4.6GHz\"}",
                299.99
        );

        assertThat(component.getId()).isNull();
        assertThat(component.getName()).isEqualTo("Ryzen 5 5600X");
        assertThat(component.getType()).isEqualTo(ComponentType.CPU);
        assertThat(component.getBrand()).isEqualTo("AMD");
        assertThat(component.getModel()).isEqualTo("5600X");
        assertThat(component.getSpecs()).isEqualTo("{\"cores\": 6, \"threads\": 12, \"base_clock\": \"3.7GHz\", \"boost_clock\": \"4.6GHz\"}");
        assertThat(component.getPrice()).isEqualTo(299.99);
    }

}
