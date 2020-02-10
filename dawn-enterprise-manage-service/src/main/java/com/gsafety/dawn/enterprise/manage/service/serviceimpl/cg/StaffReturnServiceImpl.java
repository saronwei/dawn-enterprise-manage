package com.gsafety.dawn.enterprise.manage.service.serviceimpl.cg;

import com.gsafety.dawn.enterprise.manage.contract.model.cg.StaffReturnInfoModel;
import com.gsafety.dawn.enterprise.manage.contract.service.cm.StaffReturnService;
import com.gsafety.dawn.enterprise.manage.service.datamappers.cg.StaffReturnMapper;
import com.gsafety.dawn.enterprise.manage.service.entity.cg.StaffReturnInfoEntity;
import com.gsafety.dawn.enterprise.manage.service.repository.cg.StaffReturnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.List;

@Service
public class StaffReturnServiceImpl implements StaffReturnService {


    @Autowired
    StaffReturnRepository staffReturnRepository;

    @Autowired
    StaffReturnMapper staffReturnMapper;

    @Override
    public Page<StaffReturnInfoModel> queryStaffReturnReportsPage(Pageable pageable) {
        /*Page<StaffReturnInfoEntity> pages = staffReturnRepository.findAll(new Specification<StaffReturnInfoEntity>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<StaffReturnInfoEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                return query.getRestriction();
            }
        }, pageable);*/

        Page page = new PageImpl(staffReturnMapper.entitiesToModels(staffReturnRepository.findAll()), pageable, 1);
        return page;
    }

    @Override
    public StaffReturnInfoModel getStaffInfo(String id) {
        StaffReturnInfoEntity staffReturnInfoEntity = staffReturnRepository.getOne(id);
        return staffReturnMapper.toModel(staffReturnInfoEntity);
    }
}
