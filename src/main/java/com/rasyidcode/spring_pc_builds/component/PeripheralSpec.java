package com.rasyidcode.spring_pc_builds.component;

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
        @JsonSubTypes.Type(value = PeripheralSpec.Mouse.class, name = "Mouse"),
        @JsonSubTypes.Type(value = PeripheralSpec.Keyboard.class, name = "Keyboard")
})
@Getter
@Setter
public class PeripheralSpec implements Spec {

    private String type;

    @Getter
    @Setter
    public static class Mouse extends PeripheralSpec {
        private Integer dpi;
    }

    @Getter
    @Setter
    public static class Keyboard extends PeripheralSpec {
        private String switches;
    }
}
