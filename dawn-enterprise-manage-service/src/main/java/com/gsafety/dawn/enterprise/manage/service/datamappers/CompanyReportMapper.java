package com.gsafety.dawn.enterprise.manage.service.datamappers;

import com.gsafety.dawn.enterprise.manage.contract.model.CompanyReportModel;
import com.gsafety.dawn.enterprise.manage.service.entity.CompanyReportEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyReportMapper {
    CompanyReportModel entityToModel(CompanyReportEntity companyReportEntity);

    CompanyReportEntity modelToEntity(CompanyReportModel companyReportModel);

    List<CompanyReportModel> entitiesToModels(List<CompanyReportEntity> companyReportEntities);

    List<CompanyReportEntity> modelsToEntities(List<CompanyReportModel> companyReportModels);
}
