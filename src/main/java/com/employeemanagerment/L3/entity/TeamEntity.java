package com.employeemanagerment.L3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tbl_team")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamEntity extends AbtractEntity{
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
}
