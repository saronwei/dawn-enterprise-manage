package com.gsafety.dawn.enterprise.manage.service.repository;

import com.gsafety.dawn.enterprise.manage.service.entity.EnterpriseInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 企业基本信息仓储类
 */
@Repository
@Transactional
public interface EnterpriseInfoRepository extends JpaRepository<EnterpriseInfoEntity, String>,
        JpaSpecificationExecutor<EnterpriseInfoEntity> {

    /**
     * Find by ten ant id enterprise info entity.
     *
     * @param tenAntId the ten ant id
     * @return the enterprise info entity
     */
    EnterpriseInfoEntity findByTenAntId(String tenAntId);

    /**
     * 根据条件分页查询企业信息
     * @param areaId 园区id
     * @param companyName 公司名称
     * @param pageSize 显示条数
     * @param pageIndex 当前页
     * @return 企业信息
     */
    @Query(value = "select distinct c.company_id,c.name,c.area_id,count(*) over() from be_company c where " +
            "c.area_id=?1 and c.name like %?2% order by name desc " +
            "limit ?3 offset (?4)*10 ",nativeQuery = true)
    List<Object[]> searchWithPage(String areaId, String companyName, int pageSize, int pageIndex);
}
