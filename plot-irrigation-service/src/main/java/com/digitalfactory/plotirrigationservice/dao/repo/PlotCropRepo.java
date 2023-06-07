package com.digitalfactory.plotirrigationservice.dao.repo;

import com.digitalfactory.plotirrigationservice.model.PlotCrop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface PlotCropRepo extends JpaRepository<PlotCrop,Long> {

    @Query("SELECT COUNT(pc) " +
            "FROM PlotCrop pc " +
            "WHERE pc.plot.id = :plotId " +
            "AND pc.crop.id = :cropId " +
            "AND (" +
            "     (pc.startDate BETWEEN :startDate AND :endDate) " +
            "     OR (pc.endDate BETWEEN :startDate AND :endDate) " +
            "     OR (pc.startDate <= :startDate AND pc.endDate >= :startDate) " +
            "     OR (pc.startDate <= :endDate AND pc.endDate >= :endDate) " +
            ")" +
            "AND pc.markedAsDeleted = false")
    Integer findCountPerPlotAndCrop(Long plotId, Long cropId, LocalDateTime startDate, LocalDateTime endDate);

    @Query("SELECT COUNT(pc) " +
            "FROM PlotCrop pc " +
            "WHERE pc.id != :plotCropId " +
            "AND pc.plot.id = :plotId " +
            "AND pc.crop.id = :cropId " +
            "AND (" +
            "     (pc.startDate BETWEEN :startDate AND :endDate) " +
            "     OR (pc.endDate BETWEEN :startDate AND :endDate) " +
            "     OR (pc.startDate <= :startDate AND pc.endDate >= :startDate) " +
            "     OR (pc.startDate <= :endDate AND pc.endDate >= :endDate) " +
            ")" +
            "AND pc.markedAsDeleted = false")
    Integer findCountPerPlotAndCropExcludeId(Long plotCropId, Long plotId, Long cropId, LocalDateTime startDate, LocalDateTime endDate);

}

