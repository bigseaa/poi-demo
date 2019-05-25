package com.bigsea.service;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.IOException;

public interface ExportExcelService {
    /**
     * 根据模板文件导出excel
     * @return Workbook
     */
    Workbook exportExcelByTemp() throws IOException;

    /**
     * 导出大数据量excel文件
     * @return SXSSFWorkbook
     */
    SXSSFWorkbook exportBigDataExcel();


}
