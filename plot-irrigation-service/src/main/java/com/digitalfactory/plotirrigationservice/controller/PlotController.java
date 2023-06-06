package com.digitalfactory.plotirrigationservice.controller;

import com.digitalfactory.baseservice.api.request.PaginationRequest;
import com.digitalfactory.baseservice.api.response.ApiResponse;
import com.digitalfactory.baseservice.api.response.ApiResponseBuilder;
import com.digitalfactory.baseservice.api.response.PaginationResponse;
import com.digitalfactory.baseservice.controller.BaseController;
import com.digitalfactory.plotirrigationservice.dto.PlotDto;
import com.digitalfactory.plotirrigationservice.service.PlotService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("api/plot")
public class PlotController implements BaseController<PlotService> {

    private final PlotService plotService;
    private final ApiResponseBuilder apiResponseBuilder;
    @PostMapping
    public ApiResponse<PlotDto> create(@Valid @RequestBody PlotDto plotDto) {
        return getApiResponseBuilder().buildApiSuccessResponse(getService().create(plotDto));
    }
    @PutMapping("/{id}")
    public ApiResponse<PlotDto> update(@NotNull @PathVariable Long id, @Valid @RequestBody PlotDto plotDto) {
        return getApiResponseBuilder().buildApiSuccessResponse(getService().update(plotDto,id));
    }
    @GetMapping
    public ApiResponse<List<PlotDto>> findAll(){
        return getApiResponseBuilder().buildApiSuccessResponse(getService().findAll());
    }

    @PostMapping("/find-all-paginated")
    public ApiResponse<PaginationResponse<PlotDto>> findAll(@RequestBody PaginationRequest paginationRequest) {
        return getApiResponseBuilder().buildApiSuccessResponse(getService().findAll(paginationRequest));
    }
    @GetMapping("/{id}")
    public ApiResponse<PlotDto> findById(@NotNull @PathVariable Long id){
        return getApiResponseBuilder().buildApiSuccessResponse(getService().findById(id));
    }
    @Override
    public PlotService getService() {
        return plotService;
    }

    @Override
    public ApiResponseBuilder getApiResponseBuilder() {
        return apiResponseBuilder;
    }
}
