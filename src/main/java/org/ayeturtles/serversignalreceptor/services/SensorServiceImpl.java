package org.ayeturtles.serversignalreceptor.services;

import org.ayeturtles.serversignalreceptor.model.SensorDataReq;
import org.springframework.stereotype.Service;

@Service
public class SensorServiceImpl implements SensorService {


    @Override
    public String sendDataToPersistence(SensorDataReq sensorDataReq) {
        return null;
    }
}
