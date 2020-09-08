package com.dmitrenko.itemmatchingservice.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@Builder
public class ResponseList<T> {

    @ApiModelProperty(notes = "Operation success label", position = 1)
    private final Boolean success;

    @ApiModelProperty(notes = "Description message", position = 2)
    private final String message;

    @ApiModelProperty(notes = "Response data", position = 3)
    private final List<T> data;
}
