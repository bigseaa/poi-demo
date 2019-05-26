package com.bigsea.controller;

import com.bigsea.service.ImportExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = {"/import"})
public class ImportFileController {
    @Autowired
    private ImportExcelService importExcelService;

    /**
     * 读取大批量excel文件中的数据
     * @param response HttpServletResponse
     */
    @RequestMapping(value = {"/readFile.action"}, method = RequestMethod.GET)
    public void exportByTemp(HttpServletResponse response) {
        String path = "D:\\myGithub\\poi-demo\\src\\main\\resources\\files\\import_example.xlsx";
        try {
            importExcelService.readBigDataExcel(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
