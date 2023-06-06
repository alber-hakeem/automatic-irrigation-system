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

//    @MockBean
//    private PlotTransformer plotTransformer;


    @Autowired
    private PlotService plotService;



    @Test
    public void testFindAllPlots() {
        PlotDto plot1 = new PlotDto(1L,"Plot 1",BigDecimal.valueOf(500),"");
        PlotDto plot2 = new PlotDto(2L,"Plot 2",BigDecimal.valueOf(500),"");

        List<PlotDto> mockPlots = Arrays.asList(plot1, plot2);

        when(plotService.findAll()).thenReturn(mockPlots);

        List<PlotDto> plots = plotService.findAll();
        assertEquals(2, plots.size());
        assertEquals("Plot 1", plots.get(0).getName());
        assertEquals("Plot 2", plots.get(1).getName());

        verify(plotDao, times(2)).findAll();
    }

    @Test
    public void testFindPlotById() {
        Plot plot = new Plot(1L, "Plot 3", BigDecimal.valueOf(500),"");
        PlotDto plotDto = new PlotDto(1L, "Plot 3", BigDecimal.valueOf(500),"");

        when(plotDao.findById(1L)).thenReturn(Optional.of(plot));
        when(plotService.findById(1L)).thenReturn(plotDto);

        PlotDto result = plotService.findById(1L);
        assertEquals(plotDto, result);
        verify(plotDao, times(2)).findById(1L);
    }

    @Test
    public void testCreatePlot() {
        PlotDto toBeCreatedPlotDto = new PlotDto();
        toBeCreatedPlotDto.setName("Plot 1");
        toBeCreatedPlotDto.setArea(new BigDecimal(200));

        Plot shouldBeCreatedPlot = plotService.getTransformer().transformDTOToEntity(toBeCreatedPlotDto);

        when(plotService.getDao().create((Plot) any())).thenReturn(shouldBeCreatedPlot);
        PlotDto plotDto = plotService.create(toBeCreatedPlotDto);
        assertInstanceOf(PlotDto.class, plotDto);
        assertEquals(shouldBeCreatedPlot.getName(), plotDto.getName());

        // VERIFY
        verify(plotDao, times(1)).create((Plot) any());

    }

}
