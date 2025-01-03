package com.employeemanagerment.L3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_certificate")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CertificateEntity extends AbtractEntity{
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "issue_date")
    private LocalDate date;
    @Column(name = "content")
    private String content;
    @Column(name = "field")
    private String field;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeProfileEntity employeeProfileEntity;
}
