package com.employeemanagerment.L3.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micrometer.common.lang.Nullable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeProfileRequest {
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


    @NotEmpty(message = "ADDRESS_INVALID")
    String address;

    MultipartFile multipartFile;

    @Nullable
    @Pattern(regexp = "^(https?|ftp)://[^\s/$.?#].[^\s]*$", message = "AVATAR_URL_INVALID")
    String avatar;

    @NotEmpty(message = "PHONE_INVALID")
    @Pattern(regexp = "^(0[3|5|7|8|9])[0-9]{8}$", message = "PHONE_INVALID")
    String phone;

    @NotEmpty(message = "EMAIL_INVALID")
    @Pattern(regexp = "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$", message = "EMAIL_INVALID")
    String email;

    @NotEmpty(message = "TEAM_INVALID")
    String teamCode;

    @JsonProperty("status")
    Integer status;

    String createBy;

    String updatedBy;

    LocalDate createdDate;

    LocalDate updatedDate;

    Boolean deleted;
}
