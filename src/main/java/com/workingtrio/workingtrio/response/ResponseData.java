package com.workingtrio.workingtrio.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;



@Component
@Getter
@Setter
public class ResponseData {
    private String statusMessage;
    private int statusCode;
    private String data;

}
