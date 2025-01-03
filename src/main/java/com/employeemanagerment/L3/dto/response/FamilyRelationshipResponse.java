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
public class FamilyRelationshipResponse {
    Long id;

    String code;

    String firstName;

    String lastName;

    Integer gender;

    LocalDate date;

    String identity;

    String relationship;

    String address;

    String employeeCode;

    LocalDate createdDate;

    LocalDate updatedDate;

    String createBy;

    String updatedBy;

    Boolean deleted;

    Integer status;

}
