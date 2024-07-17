package com.rasyidcode.spring_pc_builds.component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PowerSupplySpec implements Spec {

    private String wattage;

    private String efficiency;


}
