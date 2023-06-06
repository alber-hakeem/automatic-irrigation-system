package com.digitalfactory.plotirrigationservice.controller;


import com.digitalfactory.baseservice.api.request.PaginationRequest;
import com.digitalfactory.baseservice.api.response.ApiResponse;
import com.digitalfactory.baseservice.api.response.ApiResponseBuilder;
import com.digitalfactory.baseservice.api.response.PaginationResponse;
import com.digitalfactory.baseservice.controller.BaseController;
import com.digitalfactory.plotirrigationservice.dto.PlotCropDto;
import com.digitalfactory.plotirrigationservice.dto.PlotDto;
import com.digitalfactory.plotirrigationservice.service.PlotCropService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/plot-crop")
public class PlotCropController implements BaseController<PlotCropService> {

    private final PlotCropService plotCropService;
    private final ApiResponseBuilder apiResponseBuilder;
    @PostMapping
    public ApiResponse<PlotCropDto> create(@Valid @RequestBody PlotCropDto plotCropDTO) {
        return getApiResponseBuilder().buildApiSuccessResponse(getService().create(plotCropDTO));
    }

    @GetMapping
    public ApiResponse<List<PlotCropDto>> findAll(){
        return getApiResponseBuilder().buildApiSuccessResponse(getService().findAll());
    }

    @PostMapping("/find-all-paginated")
    public ApiResponse<PaginationResponse<PlotCropDto>> findAll(@RequestBody PaginationRequest paginationRequest) {
        return getApiResponseBuilder().buildApiSuccessResponse(getService().findAll(paginationRequest));
    }
    @GetMapping("/{id}")
    public ApiResponse<PlotCropDto> findById(@NotNull @PathVariable Long id){
        return getApiResponseBuilder().buildApiSuccessResponse(getService().findById(id));
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
