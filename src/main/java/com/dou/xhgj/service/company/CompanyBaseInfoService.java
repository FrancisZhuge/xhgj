package com.dou.xhgj.service.company;

import com.dou.xhgj.domain.company.CompanyBaseInfo;

import java.util.List;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017/10/17 20:20
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public interface CompanyBaseInfoService {
    public List<CompanyBaseInfo> companyBaseInfos(String areaName);
}
