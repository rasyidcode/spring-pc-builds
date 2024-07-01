package com.rasyidcode.spring_pc_builds.component;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MotherboardSpec implements Spec {

    private String socket;

    @JsonSetter("form_factor")
    private String formFactor;

    private String chipset;

}
