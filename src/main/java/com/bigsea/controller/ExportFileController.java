package com.bigsea.controller;

import com.bigsea.service.ExportExcelService;
import com.sun.deploy.net.HttpResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping(value = {"/export"})
public class ExportFileController {
    @Autowired
    private ExportExcelService exportExcelService;

    @RequestMapping(value = {"/springboot.action"})
    public String hello() {
        return "helloSpringBoot";
    }

    @RequestMapping(value = {"/exportByTemp.action"}, method = RequestMethod.GET)
    public void exportByTemp(HttpServletResponse response) {
        try {
            // 獲取工作表
            Workbook workbook = exportExcelService.exportExcelByTemp();
            // 完成下載
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            workbook.write(os);

            response.setContentType("application/octet-stream");
            response.setCharacterEncoding("utf-8");
            response.addHeader("Content-Disposition", "attachment;filename=" + "aaa.xlsx");
            ServletOutputStream outputStream = response.getOutputStream();
            os.writeTo(outputStream);
            os.close();
            outputStream.flush();
        } catch (IOException e) {

        }
    }
}
