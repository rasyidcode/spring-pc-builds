package com.rasyidcode.spring_pc_builds.component;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CaseSpec implements Spec {

    @JsonSetter("form_factor")
    private String formFactor;

    private String color;

    private Boolean windowed;
}
