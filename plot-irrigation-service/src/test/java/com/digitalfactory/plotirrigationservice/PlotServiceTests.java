package com.digitalfactory.plotirrigationservice;

import com.digitalfactory.baseservice.service.MessageService;
import com.digitalfactory.plotirrigationservice.dao.PlotDao;
import com.digitalfactory.plotirrigationservice.dto.PlotDto;
import com.digitalfactory.plotirrigationservice.service.PlotService;
import com.digitalfactory.plotirrigationservice.transformer.PlotTransformer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {PlotIrrigationServiceApplication.class})
public class PlotServiceTests {

    @Autowired
    private PlotService plotService;

    @MockBean
    private PlotTransformer plotTransformer;

    @MockBean
    private PlotDao plotDao;

    @MockBean
    private MessageService messageService;




    @Test
    public void testFindAllPlots() {
        PlotDto plot1 = new PlotDto();
        plot1.setId(1L);
        plot1.setName("Plot 1");
        PlotDto plot2 = new PlotDto();
        plot2.setId(2L);
        plot2.setName("Plot 2");
        List<PlotDto> mockPlots = Arrays.asList(plot1, plot2);
        when(plotService.findAll()).thenReturn(mockPlots);

        List<PlotDto> plots = plotService.findAll();
        assertEquals(2, plots.size());
        assertEquals("Plot 1", plots.get(0).getName());
        assertEquals("Plot 2", plots.get(1).getName());
        verify(plotDao, times(1)).findAll();
    }

    @Test
    public void testFindPlotById() {
        PlotDto plot = new PlotDto();
        plot.setId(1L);
        plot.setName("Plot 1");
        when(plotService.findById(1L)).thenReturn(plot);
        PlotDto result = plotService.findById(1L);
        assertEquals(plot, result);
        verify(plotDao, times(1)).findById(1L);
    }

    @Test
    public void testCreatePlot() {
        PlotDto plot = new PlotDto();
        plot.setId(1L);
        plot.setName("Plot 1");
        when(plotService.create(any(PlotDto.class))).thenReturn(plot);

        PlotDto plotDto = new PlotDto();
        plotDto.setName("Plot 1");

        PlotDto createdPlot = plotService.create(plotDto);

        assertEquals(plot.getName(), createdPlot.getName());

        verify(plotService, times(1)).create(any(PlotDto.class));
    }

}
