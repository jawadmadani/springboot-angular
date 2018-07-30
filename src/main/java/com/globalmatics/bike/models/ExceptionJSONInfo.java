package com.globalmatics.bike.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionJSONInfo {

    private String timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

}
