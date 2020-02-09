package com.gsafety.dawn.enterprise.manage.service.datamappers;

import com.gsafety.dawn.enterprise.manage.contract.model.EpidemicPersonModel;
import com.gsafety.dawn.enterprise.manage.service.entity.EpidemicPersonEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EpidemicPersonMapper {
    EpidemicPersonEntity modelToEntity(EpidemicPersonModel epidemicPersonModel);

    EpidemicPersonModel entityToModel(EpidemicPersonEntity epidemicPersonEntity);
}
