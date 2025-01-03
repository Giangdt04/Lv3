package com.employeemanagerment.L3.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
//bỏ những Feil Null khi chuyển sang Json
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
     Integer code = 200;
     String message;
     T result;
}
