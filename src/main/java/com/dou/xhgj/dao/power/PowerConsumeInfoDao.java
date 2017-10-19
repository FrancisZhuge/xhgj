package com.dou.xhgj.dao.power;

import com.dou.xhgj.domain.power.CompanyPowerConusmeInfo;
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



    @Select(value = {"select customer_id as companyId,power_meter_id as powerMeterId,read_value as readValue,read_date as readDate,read_time as readTime from tswk_consume_view where customer_id = #{companyId} order by read_date"})
    public List<CompanyPowerConusmeInfo> getTswkConsumeByCompanyId(int companyId);

    @Select(value = {"select customer_id as companyId,power_meter_para_id as powerMeterParaId,power_meter_id as powerMeterId,read_value as readValue,read_date as readDate,read_time as readTime from tswk_all_consume_view where customer_id = #{companyId} order by read_date,powerMeterParaId"})
    public List<PowerConsumeTswkJFGInfo> getTswkAllConsumeByCompanyId(int companyId);

    @Select(value = {"select company_id as companyId,username as userName,power_meter_para_id as powerMeterParaId,power_meter_id as powerMeterId,read_value as readValue,read_time as readTime from laster_all_read_data order by company_id,power_meter_para_id"})
    public List<PowerConsumeLasterInfo> getLasterAllConsume();

}
