package org.ayeturtles.serversignalreceptor.services;

import org.ayeturtles.serversignalreceptor.client.DbPersistenceClient;
import org.ayeturtles.serversignalreceptor.model.SensorRecordDataReq;
import org.ayeturtles.serversignalreceptor.model.SoilMoistureSensorOpe;
import org.ayeturtles.serversignalreceptor.model.nests.NestsReq;
import org.ayeturtles.serversignalreceptor.model.nests.NestsRes;
import org.ayeturtles.serversignalreceptor.model.records.RecordsReq;
import org.ayeturtles.serversignalreceptor.model.records.RecordsRes;
import org.ayeturtles.serversignalreceptor.model.sensors.SensorsRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SensorServiceImpl implements SensorService {

    @Autowired
    private DbPersistenceClient persistenceClient;


    @Override
    public String processSensorRecordData(SensorRecordDataReq sensorRecordDataReq) {
        NestsRes nestBySensorAssignedID = persistenceClient.getNestBySensorAssignedID(sensorRecordDataReq.getAssignedID());
        SensorsRes sensorsRes = nestBySensorAssignedID.getSensor();

        LocalDateTime samplingDateTime = LocalDateTime.now();
        RecordsRes lastRecordByNestID = persistenceClient.getLastRecordByNestID(String.valueOf(nestBySensorAssignedID.getId()));

        RecordsReq recordsReq = RecordsReq
                .builder()
                .id(0)
                .nest(NestsReq.builder()
                        .id(nestBySensorAssignedID.getId())
                        .build())
                .samplingDateTime(samplingDateTime)
                .temperature(processTemperature(sensorRecordDataReq.getTemperature(), sensorsRes))
                .humidityPercentage(processHumidity(sensorRecordDataReq.getMoisture(), sensorsRes))
                .x(sensorRecordDataReq.getX())
                .y(sensorRecordDataReq.getY())
                .z(sensorRecordDataReq.getZ())
                .energy(processEnergy(sensorRecordDataReq, sensorsRes,lastRecordByNestID))
                .isTesting(sensorRecordDataReq.getTesting())
                .recordNumber(sensorRecordDataReq.getNumberOfScann())
                .day(calulcateDay(sensorsRes, lastRecordByNestID))
                .build();
        return null;
    }

    private Float calulcateDay(SensorsRes sensorsRes, RecordsRes nestID) {
        if (nestID == null) {
            return sensorsRes.getNrSumar();
        }
        return nestID.getDay() + sensorsRes.getNrSumar();
    }

    private Float processEnergy(SensorRecordDataReq sensorRecordDataReq, SensorsRes sensorsRes, RecordsRes lastRecord) {
        Float xActual = sensorRecordDataReq.getX() - sensorsRes.getXerror();
        Float yActual = sensorRecordDataReq.getY() - sensorsRes.getYerror();
        Float zActual = sensorRecordDataReq.getZ() - sensorsRes.getZerror();
        Float aActual = (xActual*xActual) + (yActual*yActual) + (zActual*zActual);

        if (lastRecord == null) {
            return (float) Math.sqrt(aActual);
        }
        Float xAnterior = lastRecord.getX();
        Float yAnterior = lastRecord.getY();
        Float zAnterior = lastRecord.getZ();
        Float aAnterior = (xAnterior*xAnterior) + (yAnterior*yActual) + (zAnterior*zAnterior);

        return (aActual-aAnterior)*(aActual-aAnterior);
    }

    private Float processHumidity(int moisture, SensorsRes sensorsRes) {
        SoilMoistureSensorOpe moistureSensorOpe = new SoilMoistureSensorOpe(4095, 0,
                sensorsRes.getMoistureMinError(),
                sensorsRes.getMoistureMaxError());
        return moistureSensorOpe.processSensorValue(moisture);
    }

    private Float processTemperature(double temperature, SensorsRes sensorsRes) {
        return (float) (temperature + sensorsRes.getTemperatureError());
    }
}
