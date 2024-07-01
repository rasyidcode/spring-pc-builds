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
        @JsonSubTypes.Type(value = StorageSpec.NVMeSsd.class, name = "NVMe SSD"),
        @JsonSubTypes.Type(value = StorageSpec.HDD.class, name = "HDD")
})
@Setter
@Getter
@ToString
public class StorageSpec implements Spec{

    private String type;

    private String capacity;

    @Setter
    @Getter
    @ToString
    public static class NVMeSsd extends StorageSpec {

        @JsonSetter("read_speed")
        private String readSpeed;

        @JsonSetter("write_speed")
        private String writeSpeed;

    }

    @Getter
    @Setter
    public static class HDD extends StorageSpec {

        private String speed;

    }

}
