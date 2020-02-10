package com.gsafety.dawn.enterprise.manage.service.datamappers.cg;


import com.gsafety.dawn.enterprise.manage.contract.model.CellModel;
import com.gsafety.dawn.enterprise.manage.contract.model.DailyTroubleshootRecordModel;
import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseReport;
import com.gsafety.dawn.enterprise.manage.contract.model.cg.StaffReturnInfoModel;
import com.gsafety.dawn.enterprise.manage.service.entity.CellEntity;
import com.gsafety.dawn.enterprise.manage.service.entity.DailyTroubleshootRecordEntity;
import com.gsafety.dawn.enterprise.manage.service.entity.cg.StaffReturnInfoEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * The interface Cell mapper.
 */
@Mapper(componentModel = "spring")
public interface StaffReturnMapper {


    StaffReturnInfoModel toModel(StaffReturnInfoEntity staffReturnInfoEntity);

    // @Mapping(source = "cellTypeId",target = "cellTypeEntity.id")
    // @Mapping(source = "eventTypeId",target = "eventTypeEntity.id")
    CellEntity toEntity(StaffReturnInfoModel staffReturnInfoModel);

    List<StaffReturnInfoModel> entitiesToModels(List<StaffReturnInfoEntity> staffReturnInfoEntities);

    List<StaffReturnInfoEntity> modelsToEntities(List<StaffReturnInfoModel> models);

    StaffReturnInfoModel fromEnterpriseReport(EnterpriseReport enterpriseReport);

    List<StaffReturnInfoModel> fromEnterpriseReports(List<EnterpriseReport> enterpriseReports);

}
