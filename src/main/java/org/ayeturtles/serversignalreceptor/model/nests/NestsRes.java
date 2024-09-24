package org.ayeturtles.serversignalreceptor.model.nests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ayeturtles.serversignalreceptor.model.org.OrganizationsRes;
import org.ayeturtles.serversignalreceptor.model.sensors.SensorsRes;
import org.ayeturtles.serversignalreceptor.model.user.UserRes;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NestsRes {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("assignedID")
    private String assignedID;
    @JsonProperty("latitude")
    private String latitude;
    @JsonProperty("longitude")
    private String longitude;
    @JsonProperty("sensor")
    private SensorsRes sensor;
    @JsonProperty("organization")
    private OrganizationsRes organization;
    @JsonProperty("responsible")
    private UserRes responsible;
    @JsonProperty("isActive")
    private Boolean isActive;
    @JsonProperty("eggsQuantity")
    private Integer eggsQuantity;
    @JsonProperty("hatchlingsQuantity")
    private Integer hatchlingsQuantity;
    @JsonProperty("depredatedEggsQuantity")
    private Integer depredatedEggsQuantity;
    @JsonProperty("infertileEggs")
    private Integer infertileEggs;
    @JsonProperty("zone")
    private Character zone;
    @JsonProperty("layingDate")
    private LocalDateTime layingDate;
    @JsonProperty("collectionDate")
    private LocalDateTime collectionDate;
    @JsonProperty("monitoringStartDate")
    private LocalDateTime monitoringStartDate;
    @JsonProperty("monitoringEndDate")
    private LocalDateTime monitoringEndDate;
    @JsonProperty("firstHatchingRecordedDate")
    private LocalDateTime firstHatchingRecordedDate;
    @JsonProperty("lastHatchingRecordedDate")
    private LocalDateTime lastHatchingRecordedDate;
    @JsonProperty("nestCleaningDate")
    private LocalDateTime nestCleaningDate;
    @JsonProperty("nestBehavior")
    private String nestBehavior;
}
