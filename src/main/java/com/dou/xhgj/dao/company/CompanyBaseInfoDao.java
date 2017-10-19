package com.dou.xhgj.dao.company;

import com.dou.xhgj.domain.company.CompanyBaseInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017/10/17 19:40
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
@Mapper
public interface CompanyBaseInfoDao {
    String  COMPANYTABLE = "user_info";
    String AREATABLE = "area_info";

    /**
     *
     * @author qiao
     * @param areaName
     * @return company id 和 company 名称
     */
    @Select(value = {"SELECT user_info.id As companyId,user_info.username as companyName From",COMPANYTABLE,",",AREATABLE,"WHERE area_info.area_name=","#{areaName}","AND area_info.id = user_info.area_id"})
    public List<CompanyBaseInfo> companyBaseInfos(String areaName);
}
