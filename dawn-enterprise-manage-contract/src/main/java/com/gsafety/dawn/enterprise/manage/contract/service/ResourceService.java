package com.gsafety.dawn.enterprise.manage.contract.service;

import com.gsafety.dawn.enterprise.manage.contract.model.ResourceModel;

public interface ResourceService {

    ResourceModel addResource(ResourceModel resourceModel);

    ResourceModel updateResource(ResourceModel resourceModel);

    Boolean deleteResource(String resId);

}
