package com.digitalfactory.plotirrigationservice.controller;


import com.digitalfactory.baseservice.api.response.ApiResponse;
import com.digitalfactory.baseservice.api.response.ApiResponseBuilder;
import com.digitalfactory.baseservice.controller.BaseController;
import com.digitalfactory.plotirrigationservice.dto.PlotCropDTO;
import com.digitalfactory.plotirrigationservice.dto.PlotDto;
import com.digitalfactory.plotirrigationservice.service.PlotCropService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("api/plot-crop")
public class PlotCropController implements BaseController<PlotCropService, PlotCropDTO> {

    private final PlotCropService plotCropService;
    private final ApiResponseBuilder apiResponseBuilder;
    @PostMapping
    public ApiResponse<PlotCropDTO> create(@Valid @RequestBody PlotCropDTO plotCropDTO) {
        return getApiResponseBuilder().buildApiSuccessResponse(getService().create(plotCropDTO));
    }
    @Override
    public PlotCropService getService() {
        return plotCropService;
    }

    @Override
    public ApiResponseBuilder getApiResponseBuilder() {
        return apiResponseBuilder;
    }
}
