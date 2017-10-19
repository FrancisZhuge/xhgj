package com.dou.xhgj.service.company.impl;

import com.dou.xhgj.dao.company.CompanyBaseInfoDao;
import com.dou.xhgj.domain.company.CompanyBaseInfo;
import com.dou.xhgj.service.company.CompanyBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017/10/17 20:22
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
@Service
@Transactional
public class CompanyBaseInfoServiceImpl implements CompanyBaseInfoService {

    @Autowired
    private CompanyBaseInfoDao companyBaseInfoDao;
    @Override
    public List<CompanyBaseInfo> companyBaseInfos(String areaName) {
        return companyBaseInfoDao.companyBaseInfos(areaName);
    }
}
