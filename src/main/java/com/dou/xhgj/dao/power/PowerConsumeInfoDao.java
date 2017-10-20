package com.dou.xhgj.dao.power;

import com.dou.xhgj.domain.power.PowerConusmeTswkZongInfo;
import com.dou.xhgj.domain.power.PowerConsumeLasterInfo;
import com.dou.xhgj.domain.power.PowerConsumeTswkJFGInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017/10/18 15:35
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
@Mapper
public interface PowerConsumeInfoDao {


    @Select(value = {"select user_id as companyId,power_meter_id as powerMeterId,read_value as readValue,read_date as readDate,read_time as readTime from tswk_power_zong_consume_view where user_id = #{companyId} order by read_date"})
    public List<PowerConusmeTswkZongInfo> getTswkConsumeByCompanyId(int companyId);

    @Select(value = {"select user_id as companyId,power_meter_para_id as powerMeterParaId,power_meter_id as powerMeterId,read_value as readValue,read_date as readDate,read_time as readTime from tswk_power_all_consume_view where user_id = #{companyId} order by read_date,powerMeterParaId"})
    public List<PowerConsumeTswkJFGInfo> getTswkAllConsumeByCompanyId(int companyId);

    @Select(value = {"select user_id as companyId,username as userName,power_meter_para_id as powerMeterParaId,power_meter_id as powerMeterId,read_value as readValue,read_time as readTime from laster_power_all_read_data_view order by user_id,power_meter_para_id"})
    public List<PowerConsumeLasterInfo> getLasterAllConsume();

}
