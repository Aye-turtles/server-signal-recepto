package org.ayeturtles.serversignalreceptor.services;

import org.ayeturtles.serversignalreceptor.model.SensorRecordDataReq;

public interface SensorService {
    String processSensorRecordData(SensorRecordDataReq sensorRecordDataReq);
}
