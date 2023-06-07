package com.digitalfactory.plotirrigationservice.controller;

import com.digitalfactory.baseservice.api.response.ApiResponse;
import com.digitalfactory.baseservice.api.response.ApiResponseBuilder;
import com.digitalfactory.baseservice.controller.BaseController;
import com.digitalfactory.plotirrigationservice.dto.PlotDto;
import com.digitalfactory.plotirrigationservice.dto.PlotIrrigationSlotDto;
import com.digitalfactory.plotirrigationservice.service.PlotIrrigationSlotService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/plot-crop-slot")
public class PlotIrrigationSlotController implements BaseController<PlotIrrigationSlotService> {

    private final PlotIrrigationSlotService plotIrrigationSlotService;
    private final ApiResponseBuilder apiResponseBuilder;


    @PostMapping
    public ApiResponse<PlotDto> create(@Valid @RequestBody PlotIrrigationSlotDto plotIrrigationSlotDTO) {
        return getApiResponseBuilder().buildApiSuccessResponse(getService().create(plotIrrigationSlotDTO));
    }

    @GetMapping("/plot-crop/{id}")
    public ApiResponse<List<PlotIrrigationSlotDto>> findAllByPlotCropId(@NotNull @PathVariable Long id) {
        return getApiResponseBuilder().buildApiSuccessResponse(getService().findAllByPlotCropId(id));
    }

    @PutMapping("/{id}")
    public ApiResponse<PlotIrrigationSlotDto> update(@NotNull @PathVariable Long id, @Valid @RequestBody PlotIrrigationSlotDto plotIrrigationSlotDto) {
        return getApiResponseBuilder().buildApiSuccessResponse(getService().update(plotIrrigationSlotDto, id));
    }


    @Override
    public PlotIrrigationSlotService getService() {
        return plotIrrigationSlotService;
    }

    @Override
    public ApiResponseBuilder getApiResponseBuilder() {
        return apiResponseBuilder;
    }
}
