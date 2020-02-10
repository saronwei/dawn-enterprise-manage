package com.gsafety.dawn.enterprise.manage.service.repository;

import com.gsafety.dawn.enterprise.manage.service.entity.EnterpriseTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * The interface enterprise type repository.
 */
@Repository
@Transactional
public interface EnterpriseTypeRepository extends JpaRepository<EnterpriseTypeEntity,String> {
    @Query(nativeQuery = true,value ="select * from d_enterprise_type where enterprise_type_level = ?1 ;")
    List<EnterpriseTypeEntity> getByFirstLevel(String level);

    @Query(nativeQuery = true,value ="select * from d_enterprise_type where enterprise_type_parent_id = ?1 ;")
    List<EnterpriseTypeEntity> getByParentId(String parentId);
}
