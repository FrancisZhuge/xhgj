package com.dou.xhgj;

import com.dou.xhgj.dao.company.CompanyBaseInfoDao;
import com.dou.xhgj.dao.power.PowerConsumeInfoDao;
import com.dou.xhgj.domain.company.CompanyBaseInfo;
import com.dou.xhgj.domain.power.*;
import com.dou.xhgj.service.power.CompanyPowerConsumeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XihjApplicationTests {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Test
	public void contextLoads() {
	}

	@Autowired
	CompanyBaseInfoDao companyBaseInfoDao;
	@Test
	public void testCompanyBase(){

		List<CompanyBaseInfo> companyBaseInfoList = companyBaseInfoDao.companyBaseInfos("xhgj");
		logger.info(String.valueOf(companyBaseInfoList.size()));
		for(CompanyBaseInfo companyBaseInfo:companyBaseInfoList){
			logger.info(companyBaseInfo.toString());
		}
	}

	@Autowired
	PowerConsumeInfoDao powerConsumeInfoDao;
	@Test
	public void testPowerTswkConusume(){
		List<CompanyPowerConusmeInfo> companyPowerConusmeInfoList = powerConsumeInfoDao.getTswkConsumeByCompanyId(1);
		logger.info(String.valueOf(companyPowerConusmeInfoList.size()));
		for(CompanyPowerConusmeInfo companyPowerConusmeInfo : companyPowerConusmeInfoList){
			logger.info(companyPowerConusmeInfo.toString());
		}
	}
	@Autowired
	CompanyPowerConsumeService companyPowerConsumeService;
	@Test
	public void testPowerTswkConsumeService(){
		List<PowerTswkConsume> powerTswkConsumeList = companyPowerConsumeService.getPowerTswkConsumeByCompanyId(1);
		logger.info(String.valueOf(powerTswkConsumeList.size()));
		for(PowerTswkConsume powerTswkConsume:powerTswkConsumeList){
			logger.info(powerTswkConsume.toString());
		}
	}

	@Test
	public void testPowerTswkAllconsumeDao(){

		List<PowerConsumeTswkJFGInfo> powerConsumeTswkJFGInfoList = powerConsumeInfoDao.getTswkAllConsumeByCompanyId(1);
		logger.info(String.valueOf(powerConsumeTswkJFGInfoList.size()));
		for(PowerConsumeTswkJFGInfo powerConsumeTswkJFGInfo : powerConsumeTswkJFGInfoList){
			logger.info(powerConsumeTswkJFGInfo.toString());
		}
	}
	@Test
	public void testPowerTswkJFGService(){
		List<PowerTswkJFGConsume> powerTswkJFGConsumeList=companyPowerConsumeService.getPowerTswkJFGConsumeByCompanyId(1);
		logger.info(String.valueOf(powerTswkJFGConsumeList.size()));
		for(PowerTswkJFGConsume powerTswkJFGConsume:powerTswkJFGConsumeList){
			logger.info(powerTswkJFGConsume.toString());
		}
	}
	@Test
	public void testPowerLasterDao(){
		List<PowerConsumeLasterInfo> powerConsumeLasterInfoList = powerConsumeInfoDao.getLasterAllConsume();
		logger.info(String.valueOf(powerConsumeLasterInfoList.size()));
		for(PowerConsumeLasterInfo powerConsumeLasterInfo:powerConsumeLasterInfoList){
			logger.info(powerConsumeLasterInfo.toString());
		}

	}

	@Test
	public void testPowerLasterService(){
		List<PowerLasterConsume> powerLasterConsumeList = companyPowerConsumeService.getPowerLasterAllConsume();
		logger.info(String.valueOf(powerLasterConsumeList.size()));
		for(PowerLasterConsume powerLasterConsume:powerLasterConsumeList){
			logger.info(powerLasterConsume.toString());

		}
	}


}
