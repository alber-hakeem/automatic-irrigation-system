package com.digitalfactory.plotirrigationservice.service;

import com.digitalfactory.baseservice.service.MessageService;
import com.digitalfactory.plotirrigationservice.dao.PlotCropDao;
import com.digitalfactory.plotirrigationservice.transformer.PlotCropTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlotCropServiceImpl implements PlotCropService{

    private final PlotCropTransformer plotCropTransformer;
    private final PlotCropDao plotCropDao;
    private final MessageService messageService;
    @Override
    public PlotCropTransformer getTransformer() {
        return plotCropTransformer;
    }

    @Override
    public PlotCropDao getDao() {
        return plotCropDao;
    }

    @Override
    public MessageService getMessageService() {
        return messageService;
    }
}
