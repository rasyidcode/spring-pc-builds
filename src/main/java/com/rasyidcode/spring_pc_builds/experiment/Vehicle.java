package com.rasyidcode.spring_pc_builds.experiment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Vehicle.ElectricVehicle.class, name = "ELECTRIC_VEHICLE"),
        @JsonSubTypes.Type(value = Vehicle.FuelVehicle.class, name = "FUEL_VEHICLE")
})
@Setter
@Getter
public class Vehicle {

    private String type;

    @Setter
    @Getter
    public static class ElectricVehicle extends Vehicle {
        private String autonomy;
        private String chargingTime;
    }

    @Setter
    @Getter
    public static class FuelVehicle extends Vehicle {
        private String fuelType;
        private String transmissionType;
    }

}
