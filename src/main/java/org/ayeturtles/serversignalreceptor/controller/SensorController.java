package org.ayeturtles.serversignalreceptor.controller;

import org.ayeturtles.serversignalreceptor.model.SensorRecordDataReq;
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

    @PostMapping("/process/aye/v1")
    public ResponseEntity<String> processSensorData(@RequestBody SensorRecordDataReq sensorRecordDataReq) {
        System.out.println(sensorRecordDataReq);
        String response = service.processSensorRecordData(sensorRecordDataReq);
        return ResponseEntity.ok(response);
    }
}
