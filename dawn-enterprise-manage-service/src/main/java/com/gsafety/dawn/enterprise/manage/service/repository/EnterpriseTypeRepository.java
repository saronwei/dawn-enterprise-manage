package com.gsafety.dawn.enterprise.manage.service.repository;

import com.gsafety.dawn.enterprise.manage.service.entity.EnterpriseTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * The interface  data source  repository.
 */
@Repository
@Transactional
public interface EnterpriseTypeRepository extends JpaRepository<EnterpriseTypeEntity,String> {

}
