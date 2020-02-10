package com.gsafety.dawn.enterprise.manage.contract.service.cm;

import com.gsafety.dawn.enterprise.manage.contract.model.CellModel;
import com.gsafety.dawn.enterprise.manage.contract.model.cg.StaffReturnInfoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * The interface Cell service.
 */
public interface StaffReturnService {
    Page<StaffReturnInfoModel> queryStaffReturnReportsPage(Pageable pageable);

    StaffReturnInfoModel getStaffInfo(String id);
}
