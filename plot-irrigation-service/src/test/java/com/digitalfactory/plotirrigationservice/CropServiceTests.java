package com.digitalfactory.plotirrigationservice;

import com.digitalfactory.plotirrigationservice.dao.CropDao;
import com.digitalfactory.plotirrigationservice.dto.CropDto;
import com.digitalfactory.plotirrigationservice.model.Crop;
import com.digitalfactory.plotirrigationservice.service.CropService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.Mockito.*;


@SpringBootTest(classes = {PlotIrrigationServiceApplication.class})
public class CropServiceTests {

    @MockBean
    private CropDao cropDao;
    @Autowired
    private CropService cropService;

    @Test
    public void findAllCrops_OutputCropDtoList() {
        Crop crop1 = new Crop(1L,"Crop1","");
        Crop crop2 = new Crop(2L,"Crop2","");

        List<Crop> crops = Arrays.asList(crop1, crop2);

        when(cropDao.findAll()).thenReturn(crops);

        List<CropDto> result = cropService.findAll();
        assertEquals(2, result.size());
        assertEquals("Crop1", result.get(0).getName());
        assertEquals("Crop2", result.get(1).getName());

        verify(cropDao, times(1)).findAll();
    }

    @Test
    public void findById_OutputPlotDto() {
        Crop crop = new Crop(1L,"Crop1","");
        CropDto cropDto = cropService.getTransformer().transformEntityToDTO(crop);

        when(cropDao.findById(any())).thenReturn(Optional.of(crop));

        CropDto result = cropService.findById(1L);

        assertEquals(cropDto, result);
        verify(cropDao, times(1)).findById(1L);
    }

    @Test
    public void createCrop_InputCropDto_OutputCropDto() {
        CropDto toBeCreatedCropDto = new CropDto();
        toBeCreatedCropDto.setName("Crop1");

        Crop shouldBeCreatedCrop = cropService.getTransformer().transformDTOToEntity(toBeCreatedCropDto);

        when(cropService.getDao().create((Crop) any())).thenReturn(shouldBeCreatedCrop);
        CropDto cropDto = cropService.create(toBeCreatedCropDto);
        assertInstanceOf(CropDto.class, cropDto);
        assertEquals(shouldBeCreatedCrop.getName(), cropDto.getName());
        verify(cropDao, times(1)).create((Crop) any());
    }

}
