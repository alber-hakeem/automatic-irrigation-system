package com.digitalfactory.plotirrigationservice.controller;

import com.digitalfactory.baseservice.api.response.ApiResponse;
import com.digitalfactory.baseservice.api.response.ApiResponseBuilder;
import com.digitalfactory.baseservice.controller.BaseController;
import com.digitalfactory.plotirrigationservice.dto.CropDto;
import com.digitalfactory.plotirrigationservice.service.CropService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/crop")
public class CropController implements BaseController<CropService> {
    private final CropService cropService;
    private final ApiResponseBuilder apiResponseBuilder;
    @PostMapping
    public ApiResponse<CropDto> create(@Valid @RequestBody CropDto cropDto) {
        return getApiResponseBuilder().buildApiSuccessResponse(getService().create(cropDto));
    }
    @PutMapping("/{id}")
    public ApiResponse<CropDto> update(@NotNull  @PathVariable Long id, @Valid @RequestBody CropDto cropDto) {
        return getApiResponseBuilder().buildApiSuccessResponse(getService().update(cropDto,id));
    }
    @GetMapping
    public ApiResponse<List<CropDto>> findAll(){
        return getApiResponseBuilder().buildApiSuccessResponse(getService().findAll());
    }
    @GetMapping("/{id}")
    public ApiResponse<CropDto> findById(@NotNull @PathVariable Long id){
        return getApiResponseBuilder().buildApiSuccessResponse(getService().findById(id));
    }
    @Override
    public CropService getService() {
        return cropService;
    }

    @Override
    public ApiResponseBuilder getApiResponseBuilder() {
        return apiResponseBuilder;
    }
}
