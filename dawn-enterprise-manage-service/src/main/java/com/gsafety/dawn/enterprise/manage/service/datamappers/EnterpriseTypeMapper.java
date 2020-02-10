package com.gsafety.dawn.enterprise.manage.service.datamappers;

import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseTypeModel;
import com.gsafety.dawn.enterprise.manage.service.entity.EnterpriseTypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * The interface enterpriseType mapper.
 */
@Mapper(componentModel = "spring")
public interface EnterpriseTypeMapper {
    /**
     * The data source entity to data source model.
     *
     * @param enterpriseTypeEntity the data source entity
     * @return the data source model
     */
    EnterpriseTypeModel entityToModel(EnterpriseTypeEntity enterpriseTypeEntity);

    /**
     * Entities to models list.
     *
     * @param enterpriseTypeEntities the data source entities
     * @return the list
     */
    List<EnterpriseTypeModel> entitiesToModels(List<EnterpriseTypeEntity> enterpriseTypeEntities);
}
