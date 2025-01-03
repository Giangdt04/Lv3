package com.employeemanagerment.L3.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppException extends RuntimeException{

    private com.employeemanagerment.L3.exception.ErrorCode errorCode;

    public AppException(com.employeemanagerment.L3.exception.ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
