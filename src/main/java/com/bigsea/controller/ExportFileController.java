package com.bigsea.controller;

import com.bigsea.service.ExportExcelService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Controller
@RequestMapping(value = {"/export"})
public class ExportFileController {
    @Autowired
    private ExportExcelService exportExcelService;

    @RequestMapping(value = {"/springboot.action"})
    public String hello() {
        return "helloSpringBoot";
    }

    /**
     * 根据模板导出excel文件
     * @param response HttpServletResponse
     */
    @RequestMapping(value = {"/exportByTemp.action"}, method = RequestMethod.GET)
    public void exportByTemp(HttpServletResponse response) {
        try {
            // 獲取工作表
            Workbook workbook = exportExcelService.exportExcelByTemp();
            // 完成下載
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            workbook.write(os);

            downFile(os, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 导出大批量数据的excel
     * @param response HttpServletResponse
     */
    @RequestMapping(value = {"/exportBigDataFile.action"}, method = RequestMethod.GET)
    public void exportBigDataFile(HttpServletResponse response) {
        try {
            // 獲取工作表
            Workbook workbook = exportExcelService.exportBigDataExcel();
            // 完成下載
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            workbook.write(os);

            downFile(os, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 抽取下载部分的公共代码
     * @param os ByteArrayOutputStream
     * @param response HttpServletResponse
     * @throws IOException
     */
    public void downFile(ByteArrayOutputStream os, HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        response.addHeader("Content-Disposition", "attachment;filename=" + "test.xlsx");
        ServletOutputStream outputStream = response.getOutputStream();
        os.writeTo(outputStream);
        os.close();
        outputStream.flush();
    }
}
