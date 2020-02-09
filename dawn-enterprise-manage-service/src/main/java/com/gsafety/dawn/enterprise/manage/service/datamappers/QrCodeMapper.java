package com.gsafety.dawn.enterprise.manage.service.datamappers;

import com.gsafety.dawn.enterprise.manage.contract.model.QrCodeModel;
import com.gsafety.dawn.enterprise.manage.service.entity.QrCodeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QrCodeMapper {
    QrCodeModel entityToModel(QrCodeEntity qrCodeEntity);

    QrCodeEntity modelToEntity(QrCodeModel qrCodeModel);

    List<QrCodeModel> entitiesToModels(List<QrCodeEntity> qrCodeEntities);

    List<QrCodeEntity> modelsToEntities(List<QrCodeModel> qrCodeModels);
}
