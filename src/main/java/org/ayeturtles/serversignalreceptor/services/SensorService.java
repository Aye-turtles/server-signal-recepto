package org.ayeturtles.serversignalreceptor.services;

import org.ayeturtles.serversignalreceptor.model.SensorDataReq;

public interface SensorService {
    String sendDataToPersistence(SensorDataReq sensorDataReq);
}
