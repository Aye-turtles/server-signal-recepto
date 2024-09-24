package org.ayeturtles.serversignalreceptor.client;

import org.ayeturtles.serversignalreceptor.model.nests.NestsRes;
import org.ayeturtles.serversignalreceptor.model.records.RecordsReq;
import org.ayeturtles.serversignalreceptor.model.records.RecordsRes;

import java.util.List;

public interface DbPersistenceClient {
    NestsRes getNestBySensorAssignedID(String assignedID);

    List<RecordsRes> getRecordsByNestID(String assignedID);

    RecordsRes getLastRecordByNestID(String assignedID);

    String sendDataToExternalService(RecordsReq data);
}
