package org.ayeturtles.serversignalreceptor.model.records;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ayeturtles.serversignalreceptor.model.nests.NestsReq;
import org.ayeturtles.serversignalreceptor.model.org.OrganizationsReq;
import org.ayeturtles.serversignalreceptor.model.sensors.SensorsReq;
import org.ayeturtles.serversignalreceptor.model.user.UserReq;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecordsReq {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("nest")
    private NestsReq nest;
    @JsonProperty("samplingDateTime")
    private LocalDateTime samplingDateTime;
    @JsonProperty("temperature")
    private Float temperature;
    @JsonProperty("humidityPercentage")
    private Float humidityPercentage;
    @JsonProperty("energy")
    private Float energy;
    @JsonProperty("x")
    private Float x;
    @JsonProperty("y")
    private Float y;
    @JsonProperty("z")
    private Float z;
    @JsonProperty("isTesting")
    private Boolean isTesting;
    @JsonProperty("recordNumber")
    private Integer recordNumber;
    @JsonProperty("day")
    private Float day;
}
