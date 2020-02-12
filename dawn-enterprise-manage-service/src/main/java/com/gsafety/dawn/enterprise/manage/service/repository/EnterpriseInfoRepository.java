package com.gsafety.dawn.enterprise.manage.service.repository;

import com.gsafety.dawn.enterprise.manage.service.entity.EnterpriseInfoEntity;
import com.gsafety.dawn.enterprise.manage.service.entity.EnterpriseReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 企业基本信息仓储类
 */
@Repository
@Transactional
public interface EnterpriseInfoRepository extends JpaRepository<EnterpriseInfoEntity,String>,
        JpaSpecificationExecutor<EnterpriseInfoEntity> {
    EnterpriseInfoEntity findByTenAntId(String tenAntId);
}
