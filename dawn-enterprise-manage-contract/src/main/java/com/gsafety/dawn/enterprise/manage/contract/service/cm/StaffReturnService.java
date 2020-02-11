package com.gsafety.dawn.enterprise.manage.contract.service.cm;

import com.gsafety.dawn.enterprise.manage.contract.model.CellModel;
import com.gsafety.dawn.enterprise.manage.contract.model.TotalStatisticsQuery;
import com.gsafety.dawn.enterprise.manage.contract.model.cg.StaffReturnInfoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
 * The interface Cell service.
 */
public interface StaffReturnService {
    Map<String, Object> queryStaffReturnReportsPage(TotalStatisticsQuery tq, Pageable pageable);

    StaffReturnInfoModel getStaffInfo(String id);
}
