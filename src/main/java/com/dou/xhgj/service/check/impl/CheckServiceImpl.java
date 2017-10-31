package com.dou.xhgj.service.check.impl;

import com.dou.xhgj.service.check.CheckService;
import com.dou.xhgj.utils.CheckUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import org.springframework.stereotype.Service;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/10/30, 13:05
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Service
public class CheckServiceImpl implements CheckService{
    @Override
    public Workbook createPowerCheckExcel(Long id) {
        CellRangeAddress address = new CellRangeAddress(1,1,0,10);
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("电表日检表");
        //第2行
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.JUSTIFY);
        Row row = sheet.createRow(1);
        Cell cell = row.createCell(0);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("每日电总表记录");
        sheet.addMergedRegion(address);

        //带边框加居中
        CellStyle borders = wb.createCellStyle();
        borders.setBorderBottom(BorderStyle.THIN);
        borders.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        borders.setBorderLeft(BorderStyle.THIN);
        borders.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        borders.setBorderRight(BorderStyle.THIN);
        borders.setRightBorderColor(IndexedColors.BLACK.getIndex());
        borders.setBorderTop(BorderStyle.THIN);
        borders.setTopBorderColor(IndexedColors.BLACK.getIndex());
        borders.setAlignment(HorizontalAlignment.CENTER);
        //第4行
        Row row3 = sheet.createRow(3);
        Cell cell30 = row3.createCell(0);
        cell30.setCellValue("序号");
        cell30.setCellStyle(borders);
        Cell cell31 = row3.createCell(1);
        cell31.setCellValue("电表号");
        cell31.setCellStyle(borders);
        Cell cell32 = row3.createCell(2);
        cell32.setCellValue("位置");
        cell32.setCellStyle(borders);
        Cell cell33 = row3.createCell(3);
        cell33.setCellValue("用电名称");
        cell33.setCellStyle(borders);
        Cell cell34 = row3.createCell(4);
        cell34.setCellValue("出线号");
        cell34.setCellStyle(borders);
        Cell cell35 = row3.createCell(5);
        cell35.setCellValue("日期");
        cell35.setCellStyle(borders);
        Cell cell36 = row3.createCell(6);
        cell36.setCellValue("时间");
        cell36.setCellStyle(borders);
        Cell cell37 = row3.createCell(7);
        cell37.setCellValue("倍率");
        cell37.setCellStyle(borders);
        Cell cell38 = row3.createCell(8);
        cell38.setCellValue("有功");
        cell38.setCellStyle(borders);
        Cell cell39 = row3.createCell(9);
        cell39.setCellValue("无功");
        cell39.setCellStyle(borders);
        Cell cell310 = row3.createCell(10);
        cell310.setCellValue("功率因素");
        cell310.setCellStyle(borders);
        Cell cell311 = row3.createCell(11);
        cell311.setCellValue("用电量");
        cell311.setCellStyle(borders);
        Integer dayNumber = CheckUtil.getDayNumber();

        for(int i=0;i<dayNumber;i++){

        }
        return wb;
    }

}
