package com.digitalfactory.plotirrigationservice.dao.repo;

import com.digitalfactory.plotirrigationservice.model.PlotIrrigationSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlotIrrigationSlotRepo extends JpaRepository<PlotIrrigationSlot,Long> {
}
