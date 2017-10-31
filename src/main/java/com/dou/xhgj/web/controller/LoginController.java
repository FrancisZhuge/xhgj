package com.dou.xhgj.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/10/20, 21:58
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam("username") String username){
        return null;
    }
}
