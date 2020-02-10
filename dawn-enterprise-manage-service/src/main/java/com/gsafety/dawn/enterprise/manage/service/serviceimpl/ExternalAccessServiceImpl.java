package com.gsafety.dawn.enterprise.manage.service.serviceimpl;

import com.gsafety.dawn.enterprise.manage.contract.model.ReportedPersonInfoModel;
import com.gsafety.dawn.enterprise.manage.contract.service.ExternalAccessService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ExternalAccessServiceImpl implements ExternalAccessService {

    @Override
    public List<ReportedPersonInfoModel> getReportedPersonsInfo() {
        // todo 调用手机端接口
        return null;
    }
}
