package com.gsafety.dawn.enterprise.manage.service.datamappers;

import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseInfoModel;
import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseSimpleInfo;
import com.gsafety.dawn.enterprise.manage.service.entity.EnterpriseInfoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

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


    /**
     * Entity to simple model enterprise simple info.
     *
     * @param entity the entity
     * @return the enterprise simple info
     */
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name")
    })
    EnterpriseSimpleInfo entityToSimpleModel(EnterpriseInfoEntity entity);

    /**
     * Entities to simple models list.
     *
     * @param entities the entities
     * @return the list
     */
    List<EnterpriseSimpleInfo> entitiesToSimpleModels(List<EnterpriseInfoEntity> entities);
}
