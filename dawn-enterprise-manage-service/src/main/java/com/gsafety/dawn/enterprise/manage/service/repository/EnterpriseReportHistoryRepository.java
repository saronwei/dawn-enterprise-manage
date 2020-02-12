package com.gsafety.dawn.enterprise.manage.service.repository;

import com.gsafety.dawn.enterprise.manage.service.entity.EnterpriseReportHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * 企业上报历史记录仓储类
 */
@Repository
@Transactional
public interface EnterpriseReportHistoryRepository extends JpaRepository<EnterpriseReportHistoryEntity,String> {

}
