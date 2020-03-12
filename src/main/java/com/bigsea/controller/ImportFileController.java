package com.bigsea.controller;

import com.bigsea.service.ImportExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/import"})
public class ImportFileController {
    @Autowired
    private ImportExcelService importExcelService;

    /**
     * 读取大批量excel文件中的数据
     */
    @RequestMapping(value = {"/readFile.action"}, method = RequestMethod.GET)
    public void readFile() {
        long startTime = System.currentTimeMillis();
        String path = "D:\\myGithub\\poi-demo\\src\\main\\resources\\files\\import_example.xlsx";
        try {
            importExcelService.readBigDataExcel(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("执行完成，耗时" + (endTime - startTime)/1000 + "秒");
    }
}
