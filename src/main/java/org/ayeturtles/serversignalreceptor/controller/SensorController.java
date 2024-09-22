package org.ayeturtles.serversignalreceptor.controller;

import org.ayeturtles.serversignalreceptor.model.SensorDataReq;
import org.ayeturtles.serversignalreceptor.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sensor")
public class SensorController {

    @Autowired
    private SensorService service;

    @PostMapping("/process")
    public ResponseEntity<String> processSensorData(@RequestBody SensorDataReq sensorDataReq) {
        System.out.println(sensorDataReq);
        String response = service.sendDataToPersistence(sensorDataReq);
        return ResponseEntity.ok(response);
    }
}
