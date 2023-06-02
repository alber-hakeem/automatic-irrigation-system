package com.digitalfactory.plotirrigationservice.dao;


import com.digitalfactory.plotirrigationservice.dao.repo.PlotRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PlotDaoImpl implements PlotDao{
    private final PlotRepo plotRepo;
    @Override
    public PlotRepo getRepository() {
        return plotRepo;
    }
}
