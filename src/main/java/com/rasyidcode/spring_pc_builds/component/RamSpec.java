package com.rasyidcode.spring_pc_builds.component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class RamSpec implements Spec {

    private String capacity;

    private String type;

    private String speed;

}
