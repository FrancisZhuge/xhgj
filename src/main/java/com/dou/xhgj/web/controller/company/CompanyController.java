package com.dou.xhgj.web.controller.company;

import com.dou.xhgj.service.company.CompanyBaseInfoService;
import com.dou.xhgj.web.response.AjaxBody;
import com.dou.xhgj.web.response.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017/10/17 19:19
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
@Controller
public class CompanyController {

    /**
     *
     * @author qiao
     * @param areaName
     * @return 园区的所有企业名称
     */

    @Autowired
    private CompanyBaseInfoService companyBaseInfoService;
    @RequestMapping(value = "/{areaName}/companyinfos",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String CompanyInfos(@PathVariable String areaName){

        List companyBaseInfos = companyBaseInfoService.companyBaseInfos(areaName);

        AjaxBody reasposeAjaxBody = new AjaxBody();
        reasposeAjaxBody.setCode(ResponseCode.S_OK);
        reasposeAjaxBody.setData(companyBaseInfos);
        return reasposeAjaxBody.toString();
    }


}
