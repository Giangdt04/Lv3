package com.employeemanagerment.L3.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//Access ModiFier
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CertificateResponse {
    Long id;

    String code;

    String name;

    LocalDate date;

    String content;

    String field;

    String employeeCode;

    Integer status;

    String createBy;

    String updatedBy;

    LocalDate createdDate;

    LocalDate updatedDate;

    Boolean deleted;
}
