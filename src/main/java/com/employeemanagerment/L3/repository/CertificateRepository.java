package com.employeemanagerment.L3.repository;

import com.employeemanagerment.L3.entity.CertificateEntity;
import com.employeemanagerment.L3.entity.EmployeeProfileEntity;
import com.employeemanagerment.L3.entity.FamilyRelationshipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CertificateRepository extends JpaRepository<CertificateEntity,Long> {

    @Query(value = """
        select * from tbl_certificate
        order by id desc limit 1
    """, nativeQuery = true)
    CertificateEntity getTop1();

    boolean existsByCode(String code);

    Optional<CertificateEntity> findByCode(String code);

    @Query(value = """
                select * from tbl_certificate
                where employee_id = :employeeId
            """, nativeQuery = true)
    List<CertificateEntity> findByEmployeeId(Long employeeId);
}
