package com.gsafety.dawn.enterprise.manage.service.repository;


import com.gsafety.dawn.enterprise.manage.contract.model.DailyTroubleshootRecordModel;
import com.gsafety.dawn.enterprise.manage.service.entity.DailyTroubleshootRecordEntity;
import org.apache.commons.net.ntp.TimeStamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Repository
@Transactional
public interface DailyTroubleshootRecordRepository extends JpaRepository<DailyTroubleshootRecordEntity, String> {

    @Query
    List<DailyTroubleshootRecordEntity>  queryAllByNameAndPhone(String name , String phone);

    // 查询今日登记的
    @Query(nativeQuery = true , value = "select * from b_daily_troubleshoot_record  where create_time between ?1 and ?2 ;")
    List<DailyTroubleshootRecordEntity> todayRecord(Timestamp t1 , Timestamp t2);

    @Query(nativeQuery = true, value = "select count(*) from b_daily_troubleshoot_record  WHERE plot = ?1 ;")
    Integer queryCountByDiagnosisSituation(String diagnosisSituation);

//    @Query()
//    List<DailyTroubleshootRecordModel> queryAllByPlot(String plot);


}
