package com.digitalfactory.baseservice.controller;


import com.digitalfactory.baseservice.api.response.ApiResponseBuilder;
import com.digitalfactory.baseservice.dto.BaseDto;
import com.digitalfactory.baseservice.service.BaseService;

public interface BaseController<Service extends BaseService,Dto extends BaseDto> {
    /**
     * Service to be used by the controller
     * @return
     */
    Service getService();

    /**
     * Every Controller should use the response API builder to build the response
     * @return
     */
    ApiResponseBuilder getApiResponseBuilder();
}
