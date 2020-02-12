package com.gsafety.dawn.enterprise.manage.service.repository;

import com.gsafety.dawn.enterprise.manage.service.entity.CompanyMeasureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyMeasureRepository extends JpaRepository<CompanyMeasureEntity, String> {
    void deleteByCompanyId(String companyId);
}
