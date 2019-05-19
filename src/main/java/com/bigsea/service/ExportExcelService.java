package com.bigsea.service;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;

public interface ExportExcelService {
    /**
     * 根据模板文件导出excel
     * @return Workbook
     */
    Workbook exportExcelByTemp() throws IOException;


}
