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
     * 根据园区id查询企业集合
     *
     * @param areaId 园区id
     * @return 企业集合
     */
    List<EnterpriseInfoEntity> findByAreaId(String areaId);

    @Query(value = "select c.company_id,c.name,c.area_id from be_company c where " +
            "c.area_id=?1 and c.name like %?2% order by name asc " +
            "limit ?3 offset (?4)*10 ",nativeQuery = true)
    List<Object[]> searchWithPage(String areaId, String companyName, int pageSize, int pageIndex);
}
