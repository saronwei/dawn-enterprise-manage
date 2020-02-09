package com.gsafety.dawn.enterprise.manage.service.repository;

import com.gsafety.dawn.enterprise.manage.service.entity.ResourceInOutRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ResourceInOutRecordRepository extends JpaRepository<ResourceInOutRecordEntity, String> {
}
