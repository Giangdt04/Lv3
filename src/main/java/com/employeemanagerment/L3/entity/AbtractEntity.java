package com.employeemanagerment.L3.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class AbtractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_at")
    private LocalDate createdDate;
    @Column(name = "updated_at")
    private LocalDate updatedDate;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "deleted")
    private Boolean deleted = false;
    @Column(name = "status")
    private Integer status = 0;
}
