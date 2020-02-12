package com.gsafety.dawn.enterprise.manage.service.repository;

import com.gsafety.dawn.enterprise.manage.service.entity.CompanyReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyReportRepository extends JpaRepository<CompanyReportEntity, String>,
        JpaSpecificationExecutor<CompanyReportEntity> {

    List<CompanyReportEntity> findByCompanyId(String companyId);
}
