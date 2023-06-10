package com.digitalfactory.plotirrigationservice.service;


import com.digitalfactory.baseservice.service.MessageService;
import com.digitalfactory.plotirrigationservice.dao.CropDao;
import com.digitalfactory.plotirrigationservice.transformer.CropTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CropServiceImpl implements CropService {

    private final CropTransformer cropTransformer;
    private final CropDao cropDao;
    private final MessageService messageService;

    @Override
    public CropTransformer getTransformer() {
        return cropTransformer;
    }

    @Override
    public CropDao getDao() {
        return cropDao;
    }

    @Override
    public MessageService getMessageService() {
        return messageService;
    }
}
