package com.gsafety.dawn.enterprise.manage.service.repository.cg;

import com.gsafety.dawn.enterprise.manage.service.entity.cg.StaffReturnInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StaffReturnRepository extends JpaRepository<StaffReturnInfoEntity,String>, JpaSpecificationExecutor<StaffReturnInfoEntity> {
}
