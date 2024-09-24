package org.ayeturtles.serversignalreceptor.helpers;

import org.ayeturtles.serversignalreceptor.model.nests.NestsReq;
import org.ayeturtles.serversignalreceptor.model.nests.NestsRes;
import org.springframework.stereotype.Component;

@Component
public class NestMapperImpl implements NestMapper {

    @Override
    public NestsRes reqToRes(NestsReq req) {
        return NestsRes.builder()
                .id(req.getId())
                .assignedID(req.getAssignedID())
                .latitude(req.getLatitude())


                .build();
    }

    @Override
    public NestsReq resToReq(NestsRes res) {
        return null;
    }
}
