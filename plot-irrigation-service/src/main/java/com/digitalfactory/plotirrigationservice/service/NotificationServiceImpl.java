package com.digitalfactory.plotirrigationservice.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService{
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending notification: " + message);
    }
}
