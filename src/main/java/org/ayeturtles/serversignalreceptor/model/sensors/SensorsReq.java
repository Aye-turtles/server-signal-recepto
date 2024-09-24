package org.ayeturtles.serversignalreceptor.model.sensors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ayeturtles.serversignalreceptor.model.org.OrganizationsReq;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SensorsReq {
    private Integer id;
    private String assignedID;
    private String softwareVersion;
    private String hardwareVersion;
    private String components;
    private Float temperatureError;
    private Float moistureMinError;
    private Float moistureMaxError;
    private Float xerror;
    private Float yerror;
    private Float zerror;
    private Boolean isInUse;
    private LocalDateTime dateManufactured;
    private OrganizationsReq organization;
    private Float nrSumar;
    private Integer timing;
}
