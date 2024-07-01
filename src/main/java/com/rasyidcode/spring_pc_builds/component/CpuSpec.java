package com.rasyidcode.spring_pc_builds.component;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

@Data
public class CpuSpec implements Spec {

    private Integer cores;

    private Integer threads;

    @JsonSetter("base_clock")
    private String baseClock;

    @JsonSetter("boost_clock")
    private String boostClock;

}
