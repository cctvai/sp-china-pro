package com.example.person.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: poi工具类
 * 1、解析excel
 * @version:1.0
 */
@Slf4j
public class PoiUtil {

    /**
     *
     * @param dataList 数据
     * @param fileName 表格名称
     * @param pageSize 每页最大数据条数
     * @param headTitle 表格头部
     * @param response
     * @throws Exception
     */
    public static void exportExcelOneHead(List<List> dataList, String fileName,int pageSize, String[] headTitle, HttpServletResponse response) throws Exception {
        /**
         * 声明一个工作簿
         */
        HSSFWorkbook workbook = new HSSFWorkbook();

        int dataSize = 0;
        if (dataList != null) {
            dataSize = dataList.size();
        }
        /**
         * 设置sheet单元格样式
         */
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        //cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        log.info("[exportExcelOneHead][需要导出的数据共有   "+ dataSize + "  条] " );


        /**
         * 创建第一个sheet
         */

        //限制一个sheet显示多少条数据 5 万条数据
        /**
         * 遍历要导出到excel的List数据
         */
        int xhcs = dataList.size() / pageSize+1;
        List<List> xhList = new ArrayList<>();

        HSSFSheet sheet= null;
        HSSFRow row=null;
        HSSFCell cell=null;
        for( int k=1;k<=xhcs;k++  ){
            sheet=workbook.createSheet();
            xhList = new ArrayList<>();
            //第 K 个 sheet
            int min = (k-1)*pageSize;
            int max = k*pageSize;
            for(  int m=min;m< max && m<dataList.size() ;m++ ){
                xhList.add( dataList.get(m )  );
            }

            for(int i =-1 , rowNum = 0; i < xhList.size(); i ++, rowNum ++){

                /**
                 * 创建excel表单的第i行
                 */
                row=sheet.createRow(rowNum);
                /**
                 * 如果是一个新的sheet页
                 */
                if(rowNum == 0){
                    /**
                     * 将表头数据(字段) 填充到sheet的第一行
                     */
                    for(int j = 0; j < headTitle.length; j ++){
                        cell=   row.createCell(j);
                        cell.setCellValue(headTitle[j]);
                        /**
                         * 设置单元格的样式
                         */
                        cell.setCellStyle(cellStyle);
                        /**
                         * 设置单元格的宽度100个字符
                         */
                        sheet.setColumnWidth(j, 12 * 256);
                        /**
                         * 自动根据内容调整单元格的宽度
                         * 也可以放到表头下面的数据行，但数据量过大浏览器会卡死
                         */
                        //  sheet.autoSizeColumn(j);
                    }
                }else{
                    for(int j = 0; j < xhList.get(i).size(); j ++){
                        cell=   row.createCell(j);
                        /**
                         * 单元格内容为null时 用" " 填充
                         */
                        cell.setCellValue(xhList.get(i ).get(j) != null ? xhList.get(i).get(j).toString() : "");
                    }
                }
            }

        }

        /**
         * 弹框保存
         */
        OutputStream out = null;

        try {
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setHeader("Content-Type", "application/octet-stream");

            //解决中文乱码
            response.setHeader("Content-Disposition", "attchement;filename=" + new String((fileName + ".xls").getBytes("gb2312"), "ISO8859-1"));
            out = response.getOutputStream();
            workbook.write(out);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                out.flush();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

