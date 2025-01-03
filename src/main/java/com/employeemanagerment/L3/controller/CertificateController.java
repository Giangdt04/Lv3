package com.employeemanagerment.L3.controller;

import com.employeemanagerment.L3.dto.request.CertificateRequest;
import com.employeemanagerment.L3.dto.request.FamilyRelationshipRequest;
import com.employeemanagerment.L3.dto.response.ApiResponse;
import com.employeemanagerment.L3.dto.response.CertificateResponse;
import com.employeemanagerment.L3.dto.response.FamilyRelationshipResponse;
import com.employeemanagerment.L3.service.CertificateService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/certificate")
@Slf4j
public class CertificateController {
    @Autowired
    private CertificateService certificateService;

    @GetMapping
    public ApiResponse<List<CertificateResponse>> getAll(){
        return ApiResponse.<List<CertificateResponse>>builder()
                .result(certificateService.getAll())
                .build();
    }

    @PostMapping
    public ApiResponse<CertificateResponse> createRelation(
            @Valid @RequestBody CertificateRequest request) {
        return ApiResponse.<CertificateResponse>builder()
                .result(certificateService.add(request))
                .build();
    }

    @PutMapping("/{code}")
    public ApiResponse<CertificateResponse> updateRelation( @PathVariable("code") String code,
                                                                   @Valid @RequestBody CertificateRequest request) {
        return ApiResponse.<CertificateResponse>builder()
                .result(certificateService.update(code,request))
                .build();
    }

    @GetMapping("employee-code/{code}")
    public ApiResponse<List<CertificateResponse>> getAllByEmployeeId(@PathVariable("code") String code){
        return ApiResponse.<List<CertificateResponse>>builder()
                .result(certificateService.findAllByEmployeeId(code))
                .build();
    }

    @GetMapping("/{code}")
    public ApiResponse<CertificateResponse> findByCode(@PathVariable("code") String code){
        return ApiResponse.<CertificateResponse>builder()
                .result(certificateService.findByCode(code))
                .build();
    }

    @DeleteMapping("/{code}")
    public ApiResponse<String> deleteByCode(@PathVariable("code") String code){
        return ApiResponse.<String>builder()
                .result(certificateService.delete(code))
                .build();
    }
}
