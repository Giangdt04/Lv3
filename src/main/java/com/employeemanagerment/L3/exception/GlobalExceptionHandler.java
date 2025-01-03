package com.employeemanagerment.L3.exception;


import com.employeemanagerment.L3.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice sẽ bao quanh tất cả Exception và đưa ra cái đã thiết lập
@ControllerAdvice
public class GlobalExceptionHandler {

    //Ngoại lệ đã xử lý
    @ExceptionHandler(value = com.employeemanagerment.L3.exception.AppException.class)
    ResponseEntity<ApiResponse> handlingAppException(com.employeemanagerment.L3.exception.AppException exception){
        com.employeemanagerment.L3.exception.ErrorCode errorCode = exception.getErrorCode();
        ApiResponse response = new ApiResponse();
        response.setCode(errorCode.getCode());
        response.setMessage(errorCode.getMessage());
        return ResponseEntity
                .status(errorCode.getStatusCode())
                .body(response);
    }

    //Validation
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handlingValidation(MethodArgumentNotValidException exception){

        String enumKey = exception.getFieldError().getDefaultMessage();

        System.out.println(enumKey);

        com.employeemanagerment.L3.exception.ErrorCode errorCode = com.employeemanagerment.L3.exception.ErrorCode.INVALID_KEY;

        try {
            errorCode = com.employeemanagerment.L3.exception.ErrorCode.valueOf(enumKey);
        }catch (IllegalArgumentException e){

        }

        ApiResponse response = new ApiResponse();
        response.setCode(errorCode.getCode());

        response.setMessage(errorCode.getMessage());

        return ResponseEntity.badRequest().body(response);
    }
}
