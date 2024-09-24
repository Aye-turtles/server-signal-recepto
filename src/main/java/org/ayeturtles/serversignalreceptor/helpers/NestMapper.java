package org.ayeturtles.serversignalreceptor.helpers;

import org.ayeturtles.serversignalreceptor.model.nests.NestsReq;
import org.ayeturtles.serversignalreceptor.model.nests.NestsRes;

public interface NestMapper {
    NestsRes reqToRes(NestsReq req);
    NestsReq resToReq(NestsRes res);
}
