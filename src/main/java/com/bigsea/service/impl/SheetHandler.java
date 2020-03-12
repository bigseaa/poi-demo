package com.bigsea.service.impl;

import com.bigsea.entity.Employee;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.usermodel.XSSFComment;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义sheet基于Sax的解析处理器
 */
public class SheetHandler implements XSSFSheetXMLHandler.SheetContentsHandler {
    // 封装实体对象
    private Employee employee;

    // 实体对象集合
    private List<Employee> employeeList = new ArrayList<>(MAX_EMPLOYEE);

    // 集合最大容量
    private static final int MAX_EMPLOYEE = 1024;

    // 第几次插入数据，初始值为1
    private int times = 1;

    // 总数据量
    private int allCount = 0;

    /**
     * 当开始解析某一行的时候出发
     * @param i 行号
     */
    @Override
    public void startRow(int i) {
        if (i > 0) {
            employee = new Employee();
        }
    }

    /**
     * 当结束解析某一行的时候出发
     * @param i 行号
     */
    @Override
    public void endRow(int i) {
        // System.out.println(employee);
        employeeList.add(employee);
        allCount ++;
        if(employeeList.size() == MAX_EMPLOYEE) {
            // 假设有一个批量插入
            System.out.println("执行第" + times + "次插入");
            times ++;
            employeeList.clear();
        }
    }

    /**
     * 对行中的每一个单元格进行处理
     * @param cellName 单元格名称
     * @param value 数据
     * @param xssfComment 批注
     */
    @Override
    public void cell(String cellName, String value, XSSFComment xssfComment) {
        if (employee != null) {
            String prefix = cellName.substring(0, 1);
            switch (prefix) {
                case "A":
                    employee.setCode(Integer.valueOf(value));
                    break;
                case "B":
                    employee.setName(value);
                    break;
                case "C":
                    employee.setSex(value);
                    break;
                case "D":
                    employee.setDept(value);
                    break;
                case "E":
                    employee.setPosition(value);
                    break;
                case "F":
                    employee.setLeaderName(value);
                    break;
                case "G":
                    employee.setSalary(Double.valueOf(value));
                    break;
                case "H":
                    employee.setInDateStr(value);
                    break;
                case "I":
                    employee.setHolidayCount(Integer.valueOf(value));
                    break;
            }
        }
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public int getAllCount() {
        return allCount;
    }
}
