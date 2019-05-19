package com.bigsea.service.impl;

import com.bigsea.entity.Employee;
import com.bigsea.service.ExportExcelService;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 导出excel业务层
 */
@Service
public class ExportExcelServiceImpl implements ExportExcelService {
    /**
     * 根据模板文件导出excel
     * @return Workbook
     */
    @Override
    public Workbook exportExcelByTemp() throws IOException {
        //获取数据
        List<Employee> employeeList = getEmployeeList();
        // 加载模板
        Resource resource = new ClassPathResource("files/user_temp.xlsx");
        InputStream is = new FileInputStream(resource.getFile());
        // 根据模板加载工作簿
        Workbook workbook = new XSSFWorkbook(is);
        // 获取工作表
        Sheet sheet = workbook.getSheetAt(0);
        Sheet sheet2 = workbook.cloneSheet(0);
        // 填充工作表数据
        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);
            Row row = sheet.createRow(3 + i);
            row.createCell(0).setCellValue(employee.getCode());
            row.createCell(1).setCellValue(employee.getName());
            row.createCell(2).setCellValue(employee.getSex());
            row.createCell(3).setCellValue(employee.getDept());
            row.createCell(4).setCellValue(employee.getPosition());
            row.createCell(5).setCellValue(employee.getLeaderName());
            row.createCell(6).setCellValue(employee.getSalary());
            row.createCell(7).setCellValue(employee.getInDateStr());
            row.createCell(8).setCellValue(employee.getHolidayCount());
        }

        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);
            Row row = sheet2.createRow(3 + i);
            row.createCell(0).setCellValue(employee.getCode());
            row.createCell(1).setCellValue(employee.getName());
            row.createCell(2).setCellValue(employee.getSex());
            row.createCell(3).setCellValue(employee.getDept());
            row.createCell(4).setCellValue(employee.getPosition());
            row.createCell(5).setCellValue(employee.getLeaderName());
            row.createCell(6).setCellValue(employee.getSalary());
            row.createCell(7).setCellValue(employee.getInDateStr());
            row.createCell(8).setCellValue(employee.getHolidayCount());
        }
        // 返回工作簿
        return workbook;
    }

    /**
     * 获取模板数据
     * @return List
     */
    public List<Employee> getEmployeeList() {
        List<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Employee employee = new Employee();
            employee.setCode(100 + i);
            employee.setName("名字" + i);
            employee.setDept("牛棚");
            employee.setHolidayCount(2 + i);
            employee.setInDateStr("2018-01-02");
            employee.setLeaderName("张四");
            employee.setPosition("工程师");
            employee.setSalary(3000.0);
            employee.setSex("男");
            employeeList.add(employee);
        }
        return employeeList;
    }
}


