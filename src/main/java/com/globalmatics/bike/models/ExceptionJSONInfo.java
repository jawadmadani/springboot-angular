package com.globalmatics.bike.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ExceptionJSONInfo {

    private Date timestamp; // "timestamp": "2018-07-30T22:51:10.781+0000",
    private int status;   // "status": 500,
    private HttpStatus error;   // "error": "Internal Server Error",
    private String message; // "message": "id-2",
    private String path;    // "path": "/api/v1/bikes/2"

}
