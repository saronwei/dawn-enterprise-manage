package com.gsafety.dawn.enterprise.manage.service.serviceimpl;

import com.gsafety.dawn.enterprise.common.util.ExcelUtil;
import com.gsafety.dawn.enterprise.common.util.StringUtil;
import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseReportHistoryModel;
import com.gsafety.dawn.enterprise.manage.contract.model.EnterpriseReportModel;
import com.gsafety.dawn.enterprise.manage.contract.service.EnterpriseReportHistoryService;
import com.gsafety.dawn.enterprise.manage.service.datamappers.EnterpriseReportHistoryMapper;
import com.gsafety.dawn.enterprise.manage.service.entity.EnterpriseReportHistoryEntity;
import com.gsafety.dawn.enterprise.manage.service.repository.EnterpriseReportHistoryRepository;
import com.gsafety.java.common.page.PageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.SystemException;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * The type Enterprise upload history service.
 */
@Service
@Transactional
public class EnterpriseReportHistoryServiceImpl implements EnterpriseReportHistoryService {
    // 日志
    private static Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

    /**
     * The Enterprise report history mapper.
     */
    @Autowired
    EnterpriseReportHistoryMapper enterpriseReportHistoryMapper;

    /**
     * The Enterprise report history repository.
     */
    @Autowired
    EnterpriseReportHistoryRepository enterpriseReportHistoryRepository;

    /**
     * Pag query list.
     *
     * @param page     the page
     * @param pageSize the page size
     * @return the list
     */
    @Override
    public PageBean<EnterpriseReportHistoryModel> getEnterpriseReportHistoryByPage(int page, int pageSize) {
        try {
            PageBean<EnterpriseReportHistoryModel> pageBean = new PageBean<>();
            Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.DESC, "reportTime");
            pageBean.setData(enterpriseReportHistoryMapper.entitiesToModels(enterpriseReportHistoryRepository.findAll(pageable).getContent()));
            pageBean.setCurrentPage(page);
            pageBean.setPageSize(pageSize);
            long totalCount = enterpriseReportHistoryRepository.count();
            pageBean.setTotalCount(totalCount);
            if(totalCount%pageSize == 0)
                pageBean.setTotalPage((int)totalCount/pageSize);
            else
                pageBean.setTotalPage((int)totalCount/pageSize + 1);
            return pageBean;
        } catch (Exception e) {
            logger.error("getEnterpriseReportHistoryByPage message ", e);
            throw e;
        }
    }

    /**
     * 新增/修改企业上报历史
     * @param model
     * @return
     */
    public EnterpriseReportHistoryModel saveEnterpriseReportHistoryByHistotyModel(EnterpriseReportHistoryModel model) {
        if(model != null && StringUtil.isEmpty(model.getId())){
            model.setId(UUID.randomUUID().toString());
        }
        return enterpriseReportHistoryMapper.entityToModel(
                enterpriseReportHistoryRepository.save(
                        enterpriseReportHistoryMapper.modelToEntity(model)));
    }

    /**
     * 填写企业上报历史
     * @param model
     * @return
     */
    public EnterpriseReportHistoryModel saveEnterpriseReportHistoryByReportModel(EnterpriseReportModel model) {
        EnterpriseReportHistoryModel historyModel = enterpriseReportHistoryMapper.modelToModel(model);
        return saveEnterpriseReportHistoryByHistotyModel(historyModel);
    }

    /**
     * 根据企业上报Id删除上报记录
     * @param id
     * @return
     */
    public boolean delEnterpriseUploadHistoryById(String id){
        try{
            enterpriseReportHistoryRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            return false;
        }
    }

    /**
     * 根据Id查企业上报记录
     * @param id
     * @return
     */
    public EnterpriseReportHistoryModel findEnterpriseUploadHistoryById(String id){
        return enterpriseReportHistoryMapper.entityToModel(enterpriseReportHistoryRepository.findById(id).get());
    }
}
