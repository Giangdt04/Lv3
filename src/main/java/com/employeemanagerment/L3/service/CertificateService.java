package com.employeemanagerment.L3.service;

import com.employeemanagerment.L3.dto.request.CertificateRequest;
import com.employeemanagerment.L3.dto.request.FamilyRelationshipRequest;
import com.employeemanagerment.L3.dto.response.CertificateResponse;
import com.employeemanagerment.L3.dto.response.FamilyRelationshipResponse;

import java.util.List;

public interface CertificateService {
    CertificateResponse add(CertificateRequest request);

    List<CertificateResponse> getAll();

    CertificateResponse update(String code, CertificateRequest request);

    CertificateResponse findByCode(String code);

    List<CertificateResponse> findAllByEmployeeId(String code);

    String delete(String code);
}
