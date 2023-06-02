package com.digitalfactory.plotirrigationservice.service;

import com.digitalfactory.baseservice.service.BaseService;
import com.digitalfactory.plotirrigationservice.dao.CropDao;
import com.digitalfactory.plotirrigationservice.dto.CropDto;
import com.digitalfactory.plotirrigationservice.model.Crop;
import com.digitalfactory.plotirrigationservice.transformer.CropTransformer;

public interface CropService extends BaseService<Crop, CropDto, CropTransformer, CropDao> {
}
