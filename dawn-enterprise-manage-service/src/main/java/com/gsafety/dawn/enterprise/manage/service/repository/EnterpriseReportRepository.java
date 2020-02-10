package com.gsafety.dawn.enterprise.manage.service.repository;

import com.gsafety.dawn.enterprise.manage.service.entity.EnterpriseReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnterpriseReportRepository extends JpaRepository<EnterpriseReportEntity, String>,
        JpaSpecificationExecutor<EnterpriseReportEntity> {
    List<EnterpriseReportEntity> findByEnterpriseName(String enterpriseName);
}
