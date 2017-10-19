package com.dou.xhgj.web.controller;

import com.dou.xhgj.web.response.AjaxBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: qiao
 * @Description:
 * @Date: Created in 2017/10/17 20:38
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
@Controller
@ResponseBody
public class TestController {

    @RequestMapping(value = "/test",produces = "application/json;charset=utf-8")
    public String Test(){
        AjaxBody ajaxBody = new AjaxBody();
        ajaxBody.setData("你好");

        return ajaxBody.toString();
    }
    @RequestMapping(value = "/tswk_jfg_consume",produces = "application/json;charset=utf-8")
    public String testTswkJFgConsume(){

        return "{\"code\":200,\"data\":[{\"fengValue\":96.44999999999982,\"guValue\":95.23999999999978,\"id\":1,\"jianValue\":95.98999999999978,\"zongValue\":96.93000000000029},{\"fengValue\":97.13999999999942,\"guValue\":95.13000000000011,\"id\":2,\"jianValue\":96.31999999999971,\"zongValue\":94.26000000000022},{\"fengValue\":94.73000000000047,\"guValue\":97.21000000000004,\"id\":3,\"jianValue\":97.15000000000055,\"zongValue\":96.32999999999993}]}";
    }
    @RequestMapping(value = "/tswk_consume",produces = "application/json;charset=utf-8")
    public String testTswkConsume(){
        return "{\"code\":200,\"data\":[{\"id\":1,\"value\":96.55000000000018},{\"id\":2,\"value\":97.52999999999975},{\"id\":3,\"value\":94.29000000000087}]}";
    }

    @RequestMapping(value = "/companyinfos",produces = "application/json;charset=utf-8")
    public String companyInfos(){
        return "{\"code\":200,\"data\":[{\"companyId\":1,\"companyName\":\"3#电梯10B2配电室1\"},{\"companyId\":2,\"companyName\":\"1#电梯9B5配电室\"},{\"companyId\":3,\"companyName\":\"E座二楼强电室\"}]}";
    }
}
