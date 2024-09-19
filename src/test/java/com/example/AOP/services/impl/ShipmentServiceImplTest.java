package com.example.AOP.services.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShipmentServiceImplTest {

    @Autowired
    private ShipmentServiceImpl shipmentService;

    @Test
    void aopTestOrderPackageA(){
        shipmentService.orderPackage(1L);
    }

    @Test
    void aopTestTrackPackage(){
        shipmentService.trackPackage(1L);
    }
}
