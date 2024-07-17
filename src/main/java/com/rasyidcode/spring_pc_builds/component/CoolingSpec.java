package com.rasyidcode.spring_pc_builds.component;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CoolingSpec.AirCooler.class, name = "Air Cooler"),
        @JsonSubTypes.Type(value = CoolingSpec.LiquidCooler.class, name = "Liquid Cooler")
})
@Setter
@Getter
@ToString
public class CoolingSpec implements Spec {

    private String type;

    @Getter
    @Setter
    public static class AirCooler extends CoolingSpec {
        @JsonSetter("fan_size")
        private String fanSize;
    }

    @Getter
    @Setter
    public static class LiquidCooler extends CoolingSpec {
        @JsonSetter("radiator_size")
        private String radiatorSize;
    }

}
