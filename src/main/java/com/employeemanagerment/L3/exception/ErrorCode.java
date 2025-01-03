package com.employeemanagerment.L3.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    BAD_REQUEST(400,"Bad request",HttpStatus.BAD_REQUEST),
    INVALID_KEY(400_001,"Invalid message key",HttpStatus.UNAUTHORIZED),
    USER_EXISTED(400_002,"User existed",HttpStatus.BAD_REQUEST),
    UNAUTHENTICATED(400_003,"UnAuthenticated",HttpStatus.BAD_REQUEST),
    USERNAME_INVALID(400_004,"username must be at least 3 characters",HttpStatus.BAD_REQUEST),
    PASSWORD_INVALID(400_005,"password must be at least 5 characters",HttpStatus.BAD_REQUEST),
    NAME_INVALID(400_006,"Name invalid",HttpStatus.BAD_REQUEST),
    GENDER_INVALID(400_007,"Gender invalid",HttpStatus.BAD_REQUEST),
    DATE_INVALID(400_008,"Date invalid",HttpStatus.BAD_REQUEST),
    IDENTITY_INVALID(400_009,"Identity invalid",HttpStatus.BAD_REQUEST),
    RELATIONSHIP_INVALID(400_010,"Relationship invalid",HttpStatus.BAD_REQUEST),
    ADDRESS_INVALID(400_011,"Address invalid",HttpStatus.BAD_REQUEST),
    PHONE_INVALID(400_012,"Phone invalid",HttpStatus.BAD_REQUEST),
    EMAIL_INVALID(400_013,"Email invalid",HttpStatus.BAD_REQUEST),
    CODE_INVALID(400_014,"Code invalid",HttpStatus.BAD_REQUEST),
    EMPLOYEE_INVALID(400_015,"Employee invalid",HttpStatus.BAD_REQUEST),
    INVALID_FILE_TYPE(400_016,"This file is not image",HttpStatus.BAD_REQUEST),
    FILE_UPLOAD_FAILED(400_017,"File upload has been fail",HttpStatus.BAD_REQUEST),

    NOT_FOUND(404,"NOT FOUND",HttpStatus.NOT_FOUND),
    USER_NOT_EXISTED(404_001,"User not existed",HttpStatus.NOT_FOUND),
    ROLE_NOT_FOUND(404_002,"Role not found",HttpStatus.NOT_FOUND),
    EMPLOYEE_NOT_FOUND(404_003,"Employee not found",HttpStatus.NOT_FOUND),
    RELATIONSHIP_NOT_FOUND(404_004,"Relationship not found",HttpStatus.NOT_FOUND),
    CERTIFICATE_NOT_FOUND(404_005,"Certificate not found",HttpStatus.NOT_FOUND),
    TEAM_NOT_FOUND(404_006,"Team not found",HttpStatus.NOT_FOUND),

    UNAUTHORIZED(405,"you do not have permission",HttpStatus.FORBIDDEN),

    ;

    private int code;

    private String message;

    private HttpStatusCode statusCode;
}
