package org.ayeturtles.serversignalreceptor.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SoilMoistureSensorOpe {
    private int sensorMin;
    private int sensorMax;
    private float errorMin;
    private float errorMax;

    public float processSensorValue(int sensorValue) {
        if (sensorValue < errorMin || sensorValue > errorMax) {
            throw new IllegalArgumentException("Valor del sensor fuera de los límites permitidos.");
        }

        float humidityPercent = (float) (sensorValue - sensorMin) / (sensorMax - sensorMin) * 100;

        return Math.max(0, Math.min(humidityPercent, 100));
    }
}

