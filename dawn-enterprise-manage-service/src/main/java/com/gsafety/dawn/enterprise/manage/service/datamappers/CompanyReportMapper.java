package com.gsafety.dawn.enterprise.manage.service.datamappers;

import com.gsafety.dawn.enterprise.manage.contract.model.CompanyReportModel;
import com.gsafety.dawn.enterprise.manage.service.entity.CompanyReportEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EnterpriseInfoMapper.class})
public interface CompanyReportMapper {
    @Mapping(source = "enterpriseInfoEntity", target = "enterpriseInfoModel")
    CompanyReportModel entityToModel(CompanyReportEntity companyReportEntity);

    @InheritInverseConfiguration
    CompanyReportEntity modelToEntity(CompanyReportModel companyReportModel);

    List<CompanyReportModel> entitiesToModels(List<CompanyReportEntity> companyReportEntities);

    List<CompanyReportEntity> modelsToEntities(List<CompanyReportModel> companyReportModels);
}
