package com.dou.xhgj.web.controller.power;

import com.dou.xhgj.domain.power.PowerLasterConsume;
import com.dou.xhgj.domain.power.PowerTswkConsume;
import com.dou.xhgj.domain.power.PowerTswkJFGConsume;
import com.dou.xhgj.service.power.CompanyPowerConsumeService;
import com.dou.xhgj.web.response.AjaxBody;
import com.dou.xhgj.web.response.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017/10/18 14:58
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
@Controller
public class PowerController {

    @Autowired
    CompanyPowerConsumeService powerConsumeService;

    @RequestMapping(value = "/{areaName}/power/tswk_consume",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getTswkConsumebyComId(@RequestParam(value = "companyId") int companyId){
        List<PowerTswkConsume> powerTswkConsumeList =powerConsumeService.getPowerTswkConsumeByCompanyId(companyId);
        AjaxBody ajaxBody= new AjaxBody();
        ajaxBody.setCode(ResponseCode.S_OK);
        ajaxBody.setData(powerTswkConsumeList);
        return ajaxBody.toString();
    }

    @RequestMapping(value = "/{areaName}/power/tswk_jfg_consume",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getTswkJFGConsumeByCompanyId(@RequestParam(value = "companyId")int companyId){
        List<PowerTswkJFGConsume> powerTswkJFGConsumeList = powerConsumeService.getPowerTswkJFGConsumeByCompanyId(companyId);
        AjaxBody ajaxBody= new AjaxBody();
        ajaxBody.setCode(ResponseCode.S_OK);
        ajaxBody.setData(powerTswkJFGConsumeList);
        return ajaxBody.toString();
    }

    @RequestMapping(value = "/{areaName}/power/all_consume",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getLasterAllConsume(){
        List<PowerLasterConsume> powerLasterConsumeList = powerConsumeService.getPowerLasterAllConsume();
        AjaxBody ajaxBody = new AjaxBody();
        ajaxBody.setCode(ResponseCode.S_OK);
        ajaxBody.setData(powerLasterConsumeList);
        return ajaxBody.toString();
    }



}
