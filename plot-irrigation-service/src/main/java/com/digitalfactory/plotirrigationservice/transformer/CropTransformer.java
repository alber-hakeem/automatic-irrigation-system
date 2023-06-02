package com.digitalfactory.plotirrigationservice.transformer;


import com.digitalfactory.baseservice.transformer.BaseTransformer;
import com.digitalfactory.plotirrigationservice.dto.CropDto;
import com.digitalfactory.plotirrigationservice.model.Crop;
import com.digitalfactory.plotirrigationservice.transformer.mapper.CropMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CropTransformer implements BaseTransformer<Crop, CropDto, CropMapper> {

    private final CropMapper cropMapper;
    @Override
    public CropMapper getMapper() {
        return cropMapper;
    }
}
