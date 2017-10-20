package com.dou.xhgj.service.power.impl;

import com.dou.xhgj.dao.power.PowerConsumeInfoDao;
import com.dou.xhgj.domain.power.*;
import com.dou.xhgj.service.power.CompanyPowerConsumeService;
import com.dou.xhgj.utils.MeterParaDict;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017/10/18 21:43
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
@Transactional
@Service
public class CompanyPowerConsumeServiceImpl implements CompanyPowerConsumeService{

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PowerConsumeInfoDao powerConsumeInfoDao;
    @Override
    public List<PowerTswkConsume> getPowerTswkConsumeByCompanyId(int companyId) {
        List<PowerConusmeTswkZongInfo> powerConusmeTswkZongInfoList = powerConsumeInfoDao.getTswkConsumeByCompanyId(companyId);
        double fvalue = powerConusmeTswkZongInfoList.get(0).getReadValue();
        List<PowerTswkConsume> powerTswkConsumeList = new ArrayList<>();
        for(int i = 1; i< powerConusmeTswkZongInfoList.size(); i++){
            PowerTswkConsume powerTswkConsume = new PowerTswkConsume();
            powerTswkConsume.setId(i);
            powerTswkConsume.setValue(powerConusmeTswkZongInfoList.get(i).getReadValue()-fvalue);
            fvalue = powerConusmeTswkZongInfoList.get(i).getReadValue();
            powerTswkConsumeList.add(powerTswkConsume);
            logger.info(String.valueOf(fvalue));
        }
        return powerTswkConsumeList;
    }

    /**
     * @dep  将得到的原始数据放入到新的尖峰谷数据类中
     * @author qiao
     * @param companyId
     * @return
     */
    @Override
    public List<PowerTswkJFGConsume> getPowerTswkJFGConsumeByCompanyId(int companyId) {
        List<PowerTswkJFGConsume> powerTswkJFGConsumeList = new ArrayList<>();
        List<PowerConsumeTswkJFGInfo> powerConsumeTswkJFGInfoList = powerConsumeInfoDao.getTswkAllConsumeByCompanyId(companyId);
        if(powerConsumeTswkJFGInfoList.isEmpty())
            return null;
        String fDate = powerConsumeTswkJFGInfoList.get(0).getReadDate();
        double fjianValue=0,ffengValue=0,fguValue=0,fzongValue=0;
        PowerTswkJFGConsume powerTswkJFGConsume =null;
        int id=1;
        for(PowerConsumeTswkJFGInfo powerConsumeTswkJFGInfo : powerConsumeTswkJFGInfoList){
            if(!powerConsumeTswkJFGInfo.getReadDate().equals(fDate)){
                powerTswkJFGConsume = new PowerTswkJFGConsume();
                powerTswkJFGConsume.setId(id++);
                powerTswkJFGConsumeList.add(powerTswkJFGConsume);
                fDate = powerConsumeTswkJFGInfo.getReadDate();
            }
            switch (Integer.parseInt(powerConsumeTswkJFGInfo.getPowerMeterParaId())){
                case MeterParaDict.JianDianNeng:
                    if(powerTswkJFGConsume!=null)
                        powerTswkJFGConsume.setJianValue(powerConsumeTswkJFGInfo.getReadValue()-fjianValue);
                    fjianValue= powerConsumeTswkJFGInfo.getReadValue();
                    break;
                case MeterParaDict.FengDianNeng:
                    if(powerTswkJFGConsume!=null)
                        powerTswkJFGConsume.setFengValue(powerConsumeTswkJFGInfo.getReadValue()-ffengValue);
                    ffengValue= powerConsumeTswkJFGInfo.getReadValue();
                    break;
                case MeterParaDict.GuDianNeng:
                    if(powerTswkJFGConsume!=null)
                        powerTswkJFGConsume.setGuValue(powerConsumeTswkJFGInfo.getReadValue()-fguValue);
                    fguValue= powerConsumeTswkJFGInfo.getReadValue();
                    break;
                case MeterParaDict.YouGongZongDianNeng:
                    if(powerTswkJFGConsume!=null)
                        powerTswkJFGConsume.setZongValue(powerConsumeTswkJFGInfo.getReadValue()-fzongValue);
                    fzongValue= powerConsumeTswkJFGInfo.getReadValue();
                    break;
                default:
                    break;
            }


        }
        return powerTswkJFGConsumeList;
    }

    @Override
    public List<PowerLasterConsume> getPowerLasterAllConsume() {
        List<PowerConsumeLasterInfo> powerConsumeLasterInfoList = powerConsumeInfoDao.getLasterAllConsume();
        if(powerConsumeLasterInfoList.size()==0)
            return null;
        List<PowerLasterConsume> powerLasterConsumeList = new ArrayList<>();

        int id=1;
        int fCompanyId = powerConsumeLasterInfoList.get(0).getCompanyId();
        PowerLasterConsume powerLasterConsume = new PowerLasterConsume();
        powerLasterConsume.setId(id++);
        powerLasterConsume.setCompany(powerConsumeLasterInfoList.get(0).getUserName());
        powerLasterConsume.setReadTime(powerConsumeLasterInfoList.get(0).getReadTime());
        powerLasterConsumeList.add(powerLasterConsume);
        for(PowerConsumeLasterInfo powerConsumeLasterInfo:powerConsumeLasterInfoList){
            if (fCompanyId!=powerConsumeLasterInfo.getCompanyId()){
                fCompanyId=powerConsumeLasterInfo.getCompanyId();
                powerLasterConsume = new PowerLasterConsume();
                powerLasterConsume.setId(id++);
                powerLasterConsume.setCompany(powerConsumeLasterInfo.getUserName());
                powerLasterConsume.setReadTime(powerConsumeLasterInfo.getReadTime());
                powerLasterConsumeList.add(powerLasterConsume);
            }

            switch (Integer.parseInt(powerConsumeLasterInfo.getPowerMeterParaId())){
                case MeterParaDict.JianDianNeng:
                    powerLasterConsume.setJianDianNeng(Double.parseDouble(powerConsumeLasterInfo.getReadValue()));
                    break;
                case MeterParaDict.FengDianNeng:
                    powerLasterConsume.setFengDianNeng(Double.parseDouble(powerConsumeLasterInfo.getReadValue()));
                    break;
                case MeterParaDict.GuDianNeng:
                    powerLasterConsume.setZongDianNeng(Double.parseDouble(powerConsumeLasterInfo.getReadValue()));
                    break;
                case MeterParaDict.YouGongZongDianNeng:
                    powerLasterConsume.setZongDianNeng(Double.parseDouble(powerConsumeLasterInfo.getReadValue()));
                    break;
                case MeterParaDict.AXiangDianLiu:
                    powerLasterConsume.setaDianliu(Double.parseDouble(powerConsumeLasterInfo.getReadValue()));
                    break;
                case MeterParaDict.AXiangDianYa:
                    powerLasterConsume.setaDainya(Double.parseDouble(powerConsumeLasterInfo.getReadValue()));
                    break;
                case MeterParaDict.BXiangDianLiu:
                    powerLasterConsume.setbDianliu(Double.parseDouble(powerConsumeLasterInfo.getReadValue()));
                    break;
                case MeterParaDict.BXiangDianYa:
                    powerLasterConsume.setbDainYa(Double.parseDouble(powerConsumeLasterInfo.getReadValue()));
                    break;
                case MeterParaDict.CXiangDianLiu:
                    powerLasterConsume.setcDianliu(Double.parseDouble(powerConsumeLasterInfo.getReadValue()));
                    break;
                case MeterParaDict.CXiangDianYa:
                    powerLasterConsume.setcDianya(Double.parseDouble(powerConsumeLasterInfo.getReadValue()));
                    break;
                //待完成剩余的参数

            }

        }

        return powerLasterConsumeList;
    }


}
