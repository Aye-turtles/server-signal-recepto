package org.ayeturtles.serversignalreceptor.client;

import org.ayeturtles.serversignalreceptor.model.nests.NestsRes;
import org.ayeturtles.serversignalreceptor.model.records.RecordsReq;

public interface DbPersistenceClient {
    NestsRes getNestBySensorAssignedID(String assignedID);

    String sendDataToExternalService(RecordsReq data);
}
