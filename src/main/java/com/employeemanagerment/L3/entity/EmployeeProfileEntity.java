package com.employeemanagerment.L3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_employee_profile")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeProfileEntity extends AbtractEntity{
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
    @Column(name = "address")
    private String address;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamEntity teamEntity;
}
