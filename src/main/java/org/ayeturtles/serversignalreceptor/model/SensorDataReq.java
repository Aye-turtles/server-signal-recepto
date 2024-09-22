package org.ayeturtles.serversignalreceptor.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SensorDataReq {
    private String testing;
    private String id;
    private int numberOfScann;
    private int timing;
    private double x;
    private double y;
    private double z;
    private double temperature;
    private int moisture;
    private String version;
}
