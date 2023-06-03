package com.digitalfactory.plotirrigationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages={"com.digitalfactory"})
@EnableScheduling
public class PlotIrrigationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlotIrrigationServiceApplication.class, args);
    }

}
