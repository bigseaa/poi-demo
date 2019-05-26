package com.bigsea.service;

/**
 * 导入excel文件业务层
 * excel读取有两种方式
 * 1.用户模式：使用系列封装好的api操作excel
 * 2.事件驱动：基于sax的读取方式读取excel的xml文件
 */
public interface ImportExcelService {
    /**
     * 读取大数据量excel
     * @parma path 文件路径
     */
    void readBigDataExcel(String path) throws Exception;
}
