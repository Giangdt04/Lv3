package com.employeemanagerment.L3.service.impl;

import com.employeemanagerment.L3.dto.request.CertificateRequest;
import com.employeemanagerment.L3.dto.response.CertificateResponse;
import com.employeemanagerment.L3.dto.response.FamilyRelationshipResponse;
import com.employeemanagerment.L3.entity.CertificateEntity;
import com.employeemanagerment.L3.entity.EmployeeProfileEntity;
import com.employeemanagerment.L3.entity.FamilyRelationshipEntity;
import com.employeemanagerment.L3.exception.AppException;
import com.employeemanagerment.L3.exception.ErrorCode;
import com.employeemanagerment.L3.mapper.CertificateMapper;
import com.employeemanagerment.L3.repository.CertificateRepository;
import com.employeemanagerment.L3.repository.EmployeeProfileRepository;
import com.employeemanagerment.L3.service.CertificateService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CertificateServiceImpl implements CertificateService {

    CertificateRepository certificateRepository;

    CertificateMapper certificateMapper;

    EmployeeProfileRepository employeeProfileRepository;


    @Override
    @Transactional
    public CertificateResponse add(CertificateRequest request) {
        String code = generateCode();
        request.setCode(code);
        if (certificateRepository.existsByCode(request.getCode())) {
            throw new AppException(ErrorCode.CODE_INVALID);
        }
        if (request.getEmployeeCode() == null) {
            throw new AppException(ErrorCode.EMPLOYEE_INVALID);
        }

        CertificateEntity certificateEntity = certificateMapper.toEntity(request);
        certificateEntity.setCreatedBy(request.getCreateBy());
        certificateEntity.setCreatedDate(LocalDate.now());
        certificateEntity.setDeleted(false);

        EmployeeProfileEntity employee = employeeProfileRepository.getAllByEmployeeCode(request.getEmployeeCode())
                .orElseThrow(() -> new AppException(ErrorCode.EMPLOYEE_NOT_FOUND));

        certificateEntity.setEmployeeProfileEntity(employee);

        CertificateEntity addCertificate = certificateRepository.save(certificateEntity);

        return certificateMapper.toResponse(addCertificate);
    }

    @Override
    @Transactional
    public List<CertificateResponse> getAll() {
        List<CertificateEntity> result = certificateRepository.findAll();
        return result.stream().map(certificateMapper::toResponse).toList();
    }

    @Override
    @Transactional
    public CertificateResponse update(String code, CertificateRequest request) {
        CertificateEntity certificateEntity = this.findEmployeeByCode(code);

        if (request.getName() != null) {
            certificateEntity.setName(request.getName());
        }
        if (request.getDate() != null) {
            certificateEntity.setDate(request.getDate());
        }
        if (request.getContent() != null) {
            certificateEntity.setContent(request.getContent());
        }
        if (request.getField() != null) {
            certificateEntity.setField(request.getField());
        }
        certificateEntity.setUpdatedBy(request.getUpdatedBy());
        certificateEntity.setUpdatedDate(LocalDate.now());

        return certificateMapper.toResponse(certificateRepository.save(certificateEntity));
    }

    @Override
    @Transactional
    public CertificateResponse findByCode(String code) {
        CertificateEntity result = this.findEmployeeByCode(code);
        return certificateMapper.toResponse(result);
    }

    @Override
    @Transactional
    public List<CertificateResponse> findAllByEmployeeId(String code) {
        EmployeeProfileEntity employeeProfileEntity = employeeProfileRepository.getAllByEmployeeCode(code)
                .orElseThrow(() -> new AppException(ErrorCode.EMPLOYEE_NOT_FOUND));

        List<CertificateEntity> result = certificateRepository.findByEmployeeId(employeeProfileEntity.getId());
        return result.stream().map(certificateMapper::toResponse).toList();
    }
    @Override
    @Transactional
    public String delete(String code) {
        CertificateEntity delete = this.findEmployeeByCode(code);
        if(delete != null){
            delete.setDeleted(true);
        }
        return "deleted successfully";
    }

    private CertificateEntity findEmployeeByCode(String code){
        CertificateEntity result = certificateRepository.findByCode(code)
                .orElseThrow(() -> new AppException(ErrorCode.CERTIFICATE_NOT_FOUND));
        return result;
    }

    private String generateCode() {
        String lastCode = Optional.ofNullable(certificateRepository.getTop1())
                .map(CertificateEntity::getCode)
                .orElse("CER0");

        if (lastCode.length() > 3) {
            String prefix = lastCode.substring(0, 3);
            int number = Integer.parseInt(lastCode.substring(3));
            return prefix + (number + 1);
        } else {
            return "CER1";
        }
    }
}
