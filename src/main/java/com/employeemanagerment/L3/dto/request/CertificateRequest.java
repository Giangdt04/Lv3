package com.employeemanagerment.L3.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CertificateRequest {
    String code;

    @NotEmpty(message = "NAME NOT EMPTY")
    String name;

    LocalDate date;

    @NotEmpty(message = "CONTENT NOT EMPTY")
    String content;

    @NotEmpty(message = "FIELD NOT EMPTY")
    String field;

    String employeeCode;

    @JsonProperty("status")
    Integer status;

    String createBy;

    String updatedBy;

    LocalDate createdDate;

    LocalDate updatedDate;

    Boolean deleted;
}
