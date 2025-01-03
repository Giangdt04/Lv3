package com.employeemanagerment.L3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_family_relationship")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FamilyRelationshipEntity extends AbtractEntity{
    @Column(name = "code")
    private String code;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "gender")
    private Integer gender;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "identity")
    private String identity;
    @Column(name = "relationship")
    private String relationship;
    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeProfileEntity employeeProfileEntity;
}
