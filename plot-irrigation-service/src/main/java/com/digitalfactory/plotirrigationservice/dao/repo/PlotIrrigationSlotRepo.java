package com.digitalfactory.plotirrigationservice.dao.repo;

import com.digitalfactory.plotirrigationservice.model.PlotIrrigationSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import com.digitalfactory.automaticirrigationsystem.enums.IrrigationStatus;

@Repository
public interface PlotIrrigationSlotRepo extends JpaRepository<PlotIrrigationSlot,Long> {

    @Query("SELECT ps FROM PlotIrrigationSlot ps  WHERE :currentTime BETWEEN ps.irrigationStartTime " +
            "AND ps.irrigationEndTime AND ps.irrigationDate = :currentDay AND ps.irrigationStatus = :irrigationStatus")
    List<PlotIrrigationSlot> findSlotsByDateAndTimeAndStatus(LocalTime currentTime, LocalDate currentDay,IrrigationStatus irrigationStatus);

}
