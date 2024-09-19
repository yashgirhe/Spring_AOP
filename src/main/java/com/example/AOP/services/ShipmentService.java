package com.example.AOP.services;

import org.springframework.stereotype.Service;

@Service
public interface ShipmentService {

    String orderPackage(Long orderId);

    String trackPackage(Long orderId);
}
