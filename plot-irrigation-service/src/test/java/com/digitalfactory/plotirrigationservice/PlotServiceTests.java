package com.digitalfactory.plotirrigationservice;

import com.digitalfactory.plotirrigationservice.dao.PlotDao;
import com.digitalfactory.plotirrigationservice.dto.PlotDto;
import com.digitalfactory.plotirrigationservice.model.Plot;
import com.digitalfactory.plotirrigationservice.service.PlotService;
import com.digitalfactory.plotirrigationservice.transformer.PlotTransformer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {PlotIrrigationServiceApplication.class})
public class PlotServiceTests {
    @MockBean
    private PlotDao plotDao;
    @Autowired
    private PlotService plotService;

    @Test
    public void findAllPlots_OutputPlotDtoList() {
        Plot plot1 = new Plot(1L,"Plot1",BigDecimal.valueOf(500),"");
        Plot plot2 = new Plot(2L,"Plot2",BigDecimal.valueOf(500),"");

        List<Plot> plots = Arrays.asList(plot1, plot2);

        when(plotDao.findAll()).thenReturn(plots);

        List<PlotDto> result = plotService.findAll();
        assertEquals(2, result.size());
        assertEquals("Plot1", result.get(0).getName());
        assertEquals("Plot2", result.get(1).getName());

        verify(plotDao, times(1)).findAll();
    }

    @Test
    public void findById_OutputPlotDto() {
        Plot plot = new Plot(1L,"Plot1",BigDecimal.valueOf(500),"");
        PlotDto plotDto = plotService.getTransformer().transformEntityToDTO(plot);

        when(plotDao.findById(any())).thenReturn(Optional.of(plot));

        PlotDto result = plotService.findById(1L);

        assertEquals(plotDto, result);
        verify(plotDao, times(1)).findById(1L);
    }

    @Test
    public void createPlot_InputPlotDto_OutputPlotDto() {
        PlotDto toBeCreatedPlotDto = new PlotDto();
        toBeCreatedPlotDto.setName("Plot 1");
        toBeCreatedPlotDto.setArea(new BigDecimal(200));

        Plot shouldBeCreatedPlot = plotService.getTransformer().transformDTOToEntity(toBeCreatedPlotDto);

        when(plotService.getDao().create((Plot) any())).thenReturn(shouldBeCreatedPlot);
        PlotDto plotDto = plotService.create(toBeCreatedPlotDto);
        assertInstanceOf(PlotDto.class, plotDto);
        assertEquals(shouldBeCreatedPlot.getName(), plotDto.getName());
        verify(plotDao, times(1)).create((Plot) any());
    }

}
