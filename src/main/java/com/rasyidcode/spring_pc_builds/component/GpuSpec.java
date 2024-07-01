package com.rasyidcode.spring_pc_builds.component;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GpuSpec implements Spec {

    private String memory;

    @JsonSetter("core_clock")
    private String coreClock;

    @JsonSetter("boost_clock")
    private String boostClock;

}
