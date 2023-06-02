package com.digitalfactory.plotirrigationservice.transformer;

import com.digitalfactory.baseservice.transformer.BaseTransformer;
import com.digitalfactory.plotirrigationservice.dto.PlotCropDTO;
import com.digitalfactory.plotirrigationservice.model.PlotCrop;
import com.digitalfactory.plotirrigationservice.transformer.mapper.PlotCropMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;



@Component
@AllArgsConstructor
public class PlotCropTransformer implements BaseTransformer<PlotCrop, PlotCropDTO, PlotCropMapper> {

    private final PlotCropMapper plotCropMapper;
    @Override
    public PlotCropMapper getMapper() {
        return plotCropMapper;
    }
}
