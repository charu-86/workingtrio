package com.workingtrio.workingtrio.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Builder
public class ResponseData {
    private String statusMessage;
    private Integer statusCode;
    private Object data;

}
