package com.digitalfactory.automaticirrigationsystem.enums;

/**
 * @author Alber Rashad
 * @created 02/06/2023
 * @description
 */
public enum IrrigationStatus {
    PENDING("Pending"),
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed"),
    FAILED("Failed");

    private final String status;

    IrrigationStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
