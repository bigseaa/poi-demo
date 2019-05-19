package com.bigsea.entity;

/**
 * 员工信息实体类
 */
public class Employee {
    /**
     * 编号
     */
    private Integer code;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 部门
     */
    private String dept;

    /**
     * 职位
     */
    private String position;

    /**
     * 直系领导姓名
     */
    private String leaderName;

    /**
     * 月薪
     */
    private Double salary;

    /**
     * 入职日期
     */
    private String inDateStr;

    /**
     * 年假天数
     */
    private Integer holidayCount;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getInDateStr() {
        return inDateStr;
    }

    public void setInDateStr(String inDateStr) {
        this.inDateStr = inDateStr;
    }

    public Integer getHolidayCount() {
        return holidayCount;
    }

    public void setHolidayCount(Integer holidayCount) {
        this.holidayCount = holidayCount;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", dept='" + dept + '\'' +
                ", position='" + position + '\'' +
                ", leaderName='" + leaderName + '\'' +
                ", salary=" + salary +
                ", inDateStr='" + inDateStr + '\'' +
                ", holidayCount=" + holidayCount +
                '}';
    }
}
