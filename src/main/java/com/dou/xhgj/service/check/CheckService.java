package com.dou.xhgj.service.check;

import org.apache.poi.ss.usermodel.Workbook;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/10/30, 13:03
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public interface CheckService {
    /**
     * 创建日检表POI
     * @param id
     * @return
     */
    Workbook createPowerCheckExcel(Long id);
}
