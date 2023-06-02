package com.digitalfactory.plotirrigationservice.service;
import com.digitalfactory.baseservice.service.MessageService;
import com.digitalfactory.plotirrigationservice.dao.PlotDao;
import com.digitalfactory.plotirrigationservice.transformer.PlotTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlotServiceImpl implements PlotService{

    private final PlotTransformer plotTransformer;
    private final PlotDao plotDao;
    private final MessageService messageService;


    @Override
    public PlotTransformer getTransformer() {
        return plotTransformer;
    }

    @Override
    public PlotDao getDao() {
        return plotDao;
    }

    @Override
    public MessageService getMessageService() {
        return messageService;
    }
}
