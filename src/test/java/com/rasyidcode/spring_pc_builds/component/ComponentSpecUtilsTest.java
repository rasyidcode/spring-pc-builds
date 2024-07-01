package com.rasyidcode.spring_pc_builds.component;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ComponentSpecUtilsTest {

    @Autowired
    private ComponentSpecUtils componentSpecUtils;

    @Test
    public void test_convertCpuSpecFromJsonToObject() {
        Optional<CpuSpec> optionalCpuSpec = componentSpecUtils.convertToSpecObject(
                "{\"cores\": 6, " +
                        "\"threads\": 12, " +
                        "\"base_clock\": \"3.7GHz\", " +
                        "\"boost_clock\": \"4.6GHz\"}",
                CpuSpec.class
        );

        assertThat(optionalCpuSpec.isPresent()).isTrue();
        assertThat(optionalCpuSpec.get().getCores()).isEqualTo(6);
        assertThat(optionalCpuSpec.get().getThreads()).isEqualTo(12);
        assertThat(optionalCpuSpec.get().getBaseClock()).isEqualTo("3.7GHz");
        assertThat(optionalCpuSpec.get().getBoostClock()).isEqualTo("4.6GHz");
    }

    @Test
    public void test_convertGpuSpecFromJsonToObject() {
        Optional<GpuSpec> optionalGpuSpec = componentSpecUtils.convertToSpecObject(
                "{\"memory\": \"8GB GDDR6\", " +
                        "\"core_clock\": \"1410MHz\", " +
                        "\"boost_clock\": \"1665MHz\"}",
                GpuSpec.class
        );
    }

    @Test
    public void test_convertMotherboardSpecFromJsonToObject() {
        Optional<MotherboardSpec> optionalMotherboardSpec = componentSpecUtils.convertToSpecObject(
                "{\"socket\": \"AM4\", " +
                        "\"form_factor\": \"ATX\", " +
                        "\"chipset\": \"B550\"}",
                MotherboardSpec.class
        );
    }

    @Test
    public void test_convertRamSpecFromJsonToObject() {
        Optional<RamSpec> optionalRamSpec = componentSpecUtils.convertToSpecObject(
                "{\"capacity\": \"16GB\", " +
                        "\"type\": \"DDR4\", " +
                        "\"speed\": \"3200MHz\"}",
                RamSpec.class
        );
    }

    @Test
    public void test_convertStorageSpecFromJsonToObject() {
        Optional<StorageSpec> optionalStorageSpec = componentSpecUtils.convertToSpecObject(
                "{\"type\": \"NVMe SSD\", " +
                        "\"capacity\": \"1TB\", " +
                        "\"read_speed\": \"3500MB/s\", " +
                        "\"write_speed\": \"3300MB/s\"}",
                StorageSpec.class
        );
    }

    @Test
    public void test_convertPowerSupplySpecFromJsonToObject() {
        Optional<PowerSupplySpec> optionalPowerSupplySpec = componentSpecUtils.convertToSpecObject(
                "{\"wattage\": \"850W\", " +
                        "\"efficiency\": \"80+ Gold\"}",
                PowerSupplySpec.class
        );
    }

    @Test
    public void test_convertCaseSpecFromJsonToObject() {
        Optional<CaseSpec> optionalCaseSpec = componentSpecUtils.convertToSpecObject(
                "{\"form_factor\": \"Mid Tower\", " +
                        "\"color\": \"White\", " +
                        "\"windowed\": true}",
                CaseSpec.class
        );
    }

    @Test
    public void test_convertCoolingSpecFromJsonToObject() {
        Optional<CoolingSpec> optionalCoolingSpec = componentSpecUtils.convertToSpecObject(
                "{\"type\": \"Air Cooler\", " +
                        "\"fan_size\": \"120mm\"}",
                CoolingSpec.class
        );
    }

    @Test
    public void test_convertPeripheralSpecFromJsonToObject() {
        Optional<PeripheralSpec> optionalPeripheralSpec = componentSpecUtils.convertToSpecObject(
                "{\"type\": \"Mouse\", \"dpi\": \"16000\"}",
                PeripheralSpec.class
        );
    }

}
