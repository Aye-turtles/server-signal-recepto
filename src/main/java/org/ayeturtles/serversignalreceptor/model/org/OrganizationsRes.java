package org.ayeturtles.serversignalreceptor.model.org;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ayeturtles.serversignalreceptor.model.user.UserRes;

import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganizationsRes {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("dateActive")
    private Timestamp dateActive;
    @JsonProperty("dateInactive")
    private Timestamp dateInactive;
    @JsonProperty("isActive")
    private Boolean isActive;
    @JsonProperty("contact")
    private UserRes contact;
    @JsonProperty("members")
    private List<UserRes> members;
}
