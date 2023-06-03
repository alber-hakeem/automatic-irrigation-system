package com.digitalfactory.plotirrigationservice.dao;


import com.digitalfactory.baseservice.dao.BaseDao;
import com.digitalfactory.plotirrigationservice.dao.repo.PlotIrrigationSlotRepo;
import com.digitalfactory.plotirrigationservice.model.PlotIrrigationSlot;

import java.util.List;

public interface PlotIrrigationSlotDao extends BaseDao<PlotIrrigationSlot, PlotIrrigationSlotRepo> {

    List<PlotIrrigationSlot> findActiveIrrigationSlots();
}
