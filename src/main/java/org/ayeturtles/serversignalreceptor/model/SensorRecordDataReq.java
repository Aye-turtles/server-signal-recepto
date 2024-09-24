package org.ayeturtles.serversignalreceptor.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SensorRecordDataReq {
    private Boolean testing;
    private String assignedID;
    private int numberOfScann;
    private int timing;
    private float x;
    private float y;
    private float z;
    private double temperature;
    private int moisture;
    private String version;
}
