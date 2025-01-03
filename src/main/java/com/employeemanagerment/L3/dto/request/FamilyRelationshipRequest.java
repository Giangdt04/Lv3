package com.employeemanagerment.L3.dto.request;

import com.employeemanagerment.L3.entity.EmployeeProfileEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FamilyRelationshipRequest {
    String code;

    @NotEmpty(message = "NAME_INVALID")
    String firstName;

    @NotEmpty(message = "NAME_INVALID")
    String lastName;

    @NotNull(message = "GENDER_INVALID")
    Integer gender;

    LocalDate date;

    @NotEmpty(message = "IDENTITY_INVALID")
    String identity;

    @NotEmpty(message = "RELATIONSHIP_INVALID")
    String relationship;

    @NotEmpty(message = "ADDRESS_INVALID")
    String address;

    String employeeCode;

    @JsonProperty("status")
    Integer status;

    String createBy;

    String updatedBy;

    LocalDate createdDate;

    LocalDate updatedDate;

    Boolean deleted;
}
