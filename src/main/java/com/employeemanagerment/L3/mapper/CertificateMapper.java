package com.employeemanagerment.L3.mapper;

import com.employeemanagerment.L3.dto.request.CertificateRequest;
import com.employeemanagerment.L3.dto.request.FamilyRelationshipRequest;
import com.employeemanagerment.L3.dto.response.CertificateResponse;
import com.employeemanagerment.L3.dto.response.FamilyRelationshipResponse;
import com.employeemanagerment.L3.entity.CertificateEntity;
import com.employeemanagerment.L3.entity.FamilyRelationshipEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CertificateMapper {
    CertificateEntity toEntity(CertificateRequest request);

    //Sử dụng khi muốn tự động ánh xạ trường employeeProfileEntity.code của entity sang trường employeeCode của response
    @Mapping(source = "employeeProfileEntity.code", target = "employeeCode")
    CertificateResponse toResponse(CertificateEntity entity);
}
