package com.dou.xhgj.web.controller.check;

import com.dou.xhgj.service.check.CheckService;
import com.dou.xhgj.web.response.AjaxBody;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/10/30, 12:49
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Controller
@RequestMapping("/xhgj")
public class CheckController {
    private final static Logger LOGGER = LoggerFactory.getLogger(CheckController.class);
    @Autowired
    private CheckService checkService;

    @RequestMapping("/electric/daily_check_list")
    public void exportElectric(HttpServletResponse response,
                               @RequestParam(value = "id", required = false) Long id){
        if(id == null){
            AjaxBody body = new AjaxBody();
            body.setCode(400);
            try {
                response.getWriter().write(body.toString());
            } catch (IOException e) {
                LOGGER.error("params error write ajax body failed");
            }
            return;
        }
        Workbook wb = null;
        try {
            wb = checkService.createPowerCheckExcel(id);
        } catch (Exception e) {
            LOGGER.error("create daily check list failed");
        }
        try {
            response.setHeader("Content-Disposition","attachment;filename="+new String("电表日检表".getBytes(),"ISO-8859-1")+".xls");
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            OutputStream out = response.getOutputStream();
            wb.write(out);
            out.flush();
            out.close();
        }catch (IOException e){
            LOGGER.error("write to http failed");
        }

    }
}
