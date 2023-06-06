package com.digitalfactory.plotirrigationservice.controller;

import com.digitalfactory.baseservice.api.response.ApiResponse;
import com.digitalfactory.baseservice.api.response.ApiResponseBuilder;
import com.digitalfactory.baseservice.controller.BaseController;
import com.digitalfactory.plotirrigationservice.dto.PlotDto;
import com.digitalfactory.plotirrigationservice.dto.PlotIrrigationSlotDto;
import com.digitalfactory.plotirrigationservice.service.PlotIrrigationSlotService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
    @Override
    public PlotIrrigationSlotService getService() {
        return plotIrrigationSlotService;
    }

    @Override
    public ApiResponseBuilder getApiResponseBuilder() {
        return apiResponseBuilder;
    }
}
