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

        assertThat(optionalGpuSpec.isPresent()).isTrue();
        assertThat(optionalGpuSpec.get().getMemory()).isEqualTo("8GB GDDR6");
        assertThat(optionalGpuSpec.get().getCoreClock()).isEqualTo("1410MHz");
        assertThat(optionalGpuSpec.get().getBoostClock()).isEqualTo("1665MHz");
    }

    @Test
    public void test_convertMotherboardSpecFromJsonToObject() {
        Optional<MotherboardSpec> optionalMotherboardSpec = componentSpecUtils.convertToSpecObject(
                "{\"socket\": \"AM4\", " +
                        "\"form_factor\": \"ATX\", " +
                        "\"chipset\": \"B550\"}",
                MotherboardSpec.class
        );

        assertThat(optionalMotherboardSpec.isPresent()).isTrue();
        assertThat(optionalMotherboardSpec.get().getSocket()).isEqualTo("AM4");
        assertThat(optionalMotherboardSpec.get().getFormFactor()).isEqualTo("ATX");
        assertThat(optionalMotherboardSpec.get().getChipset()).isEqualTo("B550");
    }

    @Test
    public void test_convertRamSpecFromJsonToObject() {
        Optional<RamSpec> optionalRamSpec = componentSpecUtils.convertToSpecObject(
                "{\"capacity\": \"16GB\", " +
                        "\"type\": \"DDR4\", " +
                        "\"speed\": \"3200MHz\"}",
                RamSpec.class
        );

        assertThat(optionalRamSpec.isPresent()).isTrue();
        assertThat(optionalRamSpec.get().getCapacity()).isEqualTo("16GB");
        assertThat(optionalRamSpec.get().getType()).isEqualTo("DDR4");
        assertThat(optionalRamSpec.get().getSpeed()).isEqualTo("3200MHz");
    }

    @Test
    public void test_convertStorageSpecFromJsonToObject() {
        Optional<StorageSpec.NVMeSsd> optionalNvmeStorageSpec = componentSpecUtils.convertToSpecObject(
                "{\"type\": \"NVMe SSD\", " +
                        "\"capacity\": \"1TB\", " +
                        "\"read_speed\": \"3500MB/s\", " +
                        "\"write_speed\": \"3300MB/s\"}",
                StorageSpec.NVMeSsd.class
        );
        assertThat(optionalNvmeStorageSpec.isPresent()).isTrue();
        assertThat(optionalNvmeStorageSpec.get().getType()).isEqualTo("NVMe SSD");
        assertThat(optionalNvmeStorageSpec.get().getCapacity()).isEqualTo("1TB");
        assertThat(optionalNvmeStorageSpec.get().getReadSpeed()).isEqualTo("3500MB/s");
        assertThat(optionalNvmeStorageSpec.get().getWriteSpeed()).isEqualTo("3300MB/s");

        Optional<StorageSpec.HDD> optionalHDDStorageSpec = componentSpecUtils.convertToSpecObject(
                "{\"type\": \"HDD\"," +
                        "\"capacity\": \"2TB\"," +
                        "\"speed\": \"7200RPM\"}",
                StorageSpec.HDD.class
        );
        assertThat(optionalHDDStorageSpec.isPresent()).isTrue();
        assertThat(optionalHDDStorageSpec.get().getType()).isEqualTo("HDD");
        assertThat(optionalHDDStorageSpec.get().getCapacity()).isEqualTo("2TB");
        assertThat(optionalHDDStorageSpec.get().getSpeed()).isEqualTo("7200RPM");
    }

    @Test
    public void test_convertPowerSupplySpecFromJsonToObject() {
        Optional<PowerSupplySpec> optionalPowerSupplySpec = componentSpecUtils.convertToSpecObject(
                "{\"wattage\": \"850W\", " +
                        "\"efficiency\": \"80+ Gold\"}",
                PowerSupplySpec.class
        );
        assertThat(optionalPowerSupplySpec.isPresent()).isTrue();
        assertThat(optionalPowerSupplySpec.get().getWattage()).isEqualTo("850W");
        assertThat(optionalPowerSupplySpec.get().getEfficiency()).isEqualTo("80+ Gold");
    }

    @Test
    public void test_convertCaseSpecFromJsonToObject() {
        Optional<CaseSpec> optionalCaseSpec = componentSpecUtils.convertToSpecObject(
                "{\"form_factor\": \"Mid Tower\", " +
                        "\"color\": \"White\", " +
                        "\"windowed\": true}",
                CaseSpec.class
        );
        assertThat(optionalCaseSpec.isPresent()).isTrue();
        assertThat(optionalCaseSpec.get().getFormFactor()).isEqualTo("Mid Tower");
        assertThat(optionalCaseSpec.get().getColor()).isEqualTo("White");
        assertThat(optionalCaseSpec.get().getWindowed()).isTrue();
    }

    @Test
    public void test_convertCoolingSpecFromJsonToObject() {
        Optional<CoolingSpec.AirCooler> optionalAirCoolingSpec = componentSpecUtils.convertToSpecObject(
                "{\"type\": \"Air Cooler\", " +
                        "\"fan_size\": \"120mm\"}",
                CoolingSpec.AirCooler.class
        );
        assertThat(optionalAirCoolingSpec.isPresent()).isTrue();
        assertThat(optionalAirCoolingSpec.get().getType()).isEqualTo("Air Cooler");
        assertThat(optionalAirCoolingSpec.get().getFanSize()).isEqualTo("120mm");

        Optional<CoolingSpec.LiquidCooler> optionalLiquidCoolingSpec = componentSpecUtils.convertToSpecObject(
                "{\"type\": \"Liquid Cooler\"," +
                        "\"radiator_size\": \"280mm\"}",
                CoolingSpec.LiquidCooler.class
        );
        assertThat(optionalLiquidCoolingSpec.isPresent()).isTrue();
        assertThat(optionalLiquidCoolingSpec.get().getType()).isEqualTo("Liquid Cooler");
        assertThat(optionalLiquidCoolingSpec.get().getRadiatorSize()).isEqualTo("280mm");
    }

    @Test
    public void test_convertPeripheralSpecFromJsonToObject() {
        Optional<PeripheralSpec.Mouse> optionalMousePeripheralSpec = componentSpecUtils.convertToSpecObject(
                "{\"type\": \"Mouse\", \"dpi\": \"16000\"}",
                PeripheralSpec.Mouse.class
        );
        assertThat(optionalMousePeripheralSpec.isPresent()).isTrue();
        assertThat(optionalMousePeripheralSpec.get().getType()).isEqualTo("Mouse");
        assertThat(optionalMousePeripheralSpec.get().getDpi()).isEqualTo(16000);

        Optional<PeripheralSpec.Keyboard> optionalKeyboardPeripheralSpec = componentSpecUtils.convertToSpecObject(
                "{\"type\": \"Keyboard\", \"switches\": \"Cherry MX Speed\"}",
                PeripheralSpec.Keyboard.class
        );
        assertThat(optionalKeyboardPeripheralSpec.isPresent()).isTrue();
        assertThat(optionalKeyboardPeripheralSpec.get().getType()).isEqualTo("Keyboard");
        assertThat(optionalKeyboardPeripheralSpec.get().getSwitches()).isEqualTo("Cherry MX Speed");
    }

}
