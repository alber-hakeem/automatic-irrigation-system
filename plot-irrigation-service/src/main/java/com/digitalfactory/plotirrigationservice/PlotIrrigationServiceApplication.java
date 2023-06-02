package com.digitalfactory.plotirrigationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.digitalfactory"})
public class PlotIrrigationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlotIrrigationServiceApplication.class, args);
    }

}
