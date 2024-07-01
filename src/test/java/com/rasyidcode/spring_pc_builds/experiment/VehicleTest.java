package com.rasyidcode.spring_pc_builds.experiment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class VehicleTest {

    @Test
    public void test_deserializeVehicleFromJSONString() throws JsonProcessingException {
        String json = "{\"type\":\"ELECTRIC_VEHICLE\",\"autonomy\":\"500\",\"chargingTime\":\"200\"}";

        Vehicle vehicle = new ObjectMapper().readerFor(Vehicle.class).readValue(json);

        assertThat(vehicle.getClass()).isEqualTo(Vehicle.ElectricVehicle.class);
    }

}
