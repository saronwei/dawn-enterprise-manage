package com.gsafety.dawn.enterprise.manage.service.datamappers;

import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseReportModel;
import com.gsafety.dawn.enterprise.manage.service.entity.EnterpriseReportEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EnterpriseReportMapper {
    EnterpriseReportModel entityToModel(EnterpriseReportEntity enterpriseReportEntity);

    EnterpriseReportEntity modelToEntity(EnterpriseReportModel enterpriseReportModel);

    List<EnterpriseReportModel> entitiesToModels(List<EnterpriseReportEntity> enterpriseReportEntities);

    List<EnterpriseReportEntity> modelsToEntities(List<EnterpriseReportModel> enterpriseReportModels);
}
