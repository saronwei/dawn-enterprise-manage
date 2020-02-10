package com.gsafety.dawn.enterprise.manage.service.datamappers;

import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseReportHistoryModel;
import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseReportModel;
import com.gsafety.dawn.enterprise.manage.service.entity.EnterpriseReportHistoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * The interface Enterprise upload history mapper.
 */
@Mapper(componentModel = "spring")
public interface EnterpriseReportHistoryMapper {
    /**
     * Entity to model enterprise upload history model.
     *
     * @param entity the entity
     * @return the enterprise upload history model
     */
    EnterpriseReportHistoryModel entityToModel(EnterpriseReportHistoryEntity entity);

    /**
     * Model to entity enterprise upload history entity.
     *
     * @param model the model
     * @return the enterprise upload history entity
     */
    EnterpriseReportHistoryEntity modelToEntity(EnterpriseReportHistoryModel model);

    /**
     * Model to entity enterprise upload history entity.
     *
     * @param model the model
     * @return the enterprise upload history entity
     */
    @Mappings({
            @Mapping(ignore = true, target = "id"),
    })
    EnterpriseReportHistoryModel modelToModel(EnterpriseReportModel model);

    /**
     * Entities to models list.
     *
     * @param entities the entities
     * @return the list
     */
    List<EnterpriseReportHistoryModel> entitiesToModels(List<EnterpriseReportHistoryEntity> entities);

    /**
     * Models to entities list.
     *
     * @param models the models
     * @return the list
     */
    List<EnterpriseReportHistoryEntity> modelsToEntities(List<EnterpriseReportHistoryModel> models);
}
