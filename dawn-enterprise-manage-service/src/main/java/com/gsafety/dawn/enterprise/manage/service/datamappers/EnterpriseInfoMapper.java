package com.gsafety.dawn.enterprise.manage.service.datamappers;

import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseInfoModel;
import com.gsafety.dawn.enterprise.manage.service.entity.EnterpriseInfoEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * The interface Enterprise info mapper.
 */
@Mapper(componentModel = "spring")
public interface EnterpriseInfoMapper {

    /**
     * Entity to model enterprise info model.
     *
     * @param entity the entity
     * @return the enterprise info model
     */
    EnterpriseInfoModel entityToModel(EnterpriseInfoEntity entity);

    /**
     * Model to entity enterprise info entity.
     *
     * @param model the model
     * @return the enterprise info entity
     */
    EnterpriseInfoEntity modelToEntity(EnterpriseInfoModel model);

    /**
     * Entities to models list.
     *
     * @param entities the entities
     * @return the list
     */
    List<EnterpriseInfoModel> entitiesToModels(List<EnterpriseInfoEntity> entities);

    /**
     * Models to entities list.
     *
     * @param models the models
     * @return the list
     */
    List<EnterpriseInfoEntity> modelsToEntities(List<EnterpriseInfoModel> models);
}
