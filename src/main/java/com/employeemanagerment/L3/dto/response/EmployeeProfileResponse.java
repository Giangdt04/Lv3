package com.employeemanagerment.L3.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micrometer.common.lang.Nullable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
public class EmployeeProfileResponse {
    Long id;

    String code;

    String firstName;

    String lastName;

    Integer gender;

    LocalDate date;

    String identity;

    String address;

    String avatar;

    String phone;

    String email;

    String teamCode;

    Integer status;

    String createBy;

    String updatedBy;

    LocalDate createdDate;

    LocalDate updatedDate;

    Boolean deleted;
}
