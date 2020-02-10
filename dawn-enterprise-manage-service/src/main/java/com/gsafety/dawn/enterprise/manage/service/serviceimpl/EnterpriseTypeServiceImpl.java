package com.gsafety.dawn.enterprise.manage.service.serviceimpl;

import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseTypeModel;
import com.gsafety.dawn.enterprise.manage.contract.service.EnterpriseTypeService;
import com.gsafety.dawn.enterprise.manage.service.datamappers.EnterpriseTypeMapper;
import com.gsafety.dawn.enterprise.manage.service.repository.EnterpriseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * The type enterprise type service.
 */
@Service
@Transactional
public class EnterpriseTypeServiceImpl implements EnterpriseTypeService {

    @Autowired
    private EnterpriseTypeMapper enterpriseTypeMapper;
    @Autowired
    private EnterpriseTypeRepository enterpriseTypeRepository;


    @Override
    public List<EnterpriseTypeModel> getFirstLevelEnterprise() {
        return null;
    }

    @Override
    public List<EnterpriseTypeModel> getChildNodeEnterpriseById(String parentId) {
        return null;
    }
}
