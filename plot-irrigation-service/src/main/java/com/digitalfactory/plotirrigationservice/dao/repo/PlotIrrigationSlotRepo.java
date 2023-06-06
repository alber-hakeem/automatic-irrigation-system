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

    @Query("SELECT  COUNT(pis) " +
            "FROM PlotIrrigationSlot pis " +
            "WHERE pis.plotCrop.id = :plotCropId " +
            "AND pis.irrigationDate = :irrigationDate " +
            "AND (" +
            "     pis.irrigationStartTime BETWEEN :irrigationStartTime AND :irrigationEndTime " +
            "     OR pis.irrigationEndTime BETWEEN :irrigationStartTime AND :irrigationEndTime " +
            "     OR (pis.irrigationStartTime <= :irrigationStartTime AND pis.irrigationEndTime >= :irrigationEndTime)" +
            ")" +
            "AND pis.markedAsDeleted = false ")
    Integer findCountPerCropAndSlots(Long plotCropId, LocalDate irrigationDate, LocalTime irrigationStartTime, LocalTime irrigationEndTime);

    List<PlotIrrigationSlot> findAllByPlotCropIdAndMarkedAsDeletedFalse(Long plotCropId);


}
