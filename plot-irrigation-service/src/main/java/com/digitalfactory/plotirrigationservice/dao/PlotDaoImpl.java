package com.digitalfactory.plotirrigationservice.dao;


import com.digitalfactory.plotirrigationservice.dao.repo.PlotRepo;
import com.digitalfactory.plotirrigationservice.model.PlotIrrigationSlot;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class PlotDaoImpl implements PlotDao{
    private final PlotRepo plotRepo;
    @Override
    public PlotRepo getRepository() {
        return plotRepo;
    }


}
