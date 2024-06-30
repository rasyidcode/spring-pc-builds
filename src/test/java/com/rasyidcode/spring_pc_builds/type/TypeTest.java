package com.rasyidcode.spring_pc_builds.type;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TypeTest {

    @Test
    public void test_createNewType() {
        Type type = new Type("CPU");

        assertThat(type.getId()).isNull();
        assertThat(type.getName()).isEqualTo("CPU");
    }

}
