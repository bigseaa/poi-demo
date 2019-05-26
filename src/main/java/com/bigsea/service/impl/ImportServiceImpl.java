package com.bigsea.service.impl;

import com.bigsea.service.ImportExcelService;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.InputStream;

/**
 * 导入excel文件业务层
 * excel读取有两种方式
 * 1.用户模式：使用系列封装好的api操作excel
 * 2.事件驱动：基于sax的读取方式读取excel的xml文件
 */
@Service
public class ImportServiceImpl implements ImportExcelService {
    /**
     * 读取大数据量excel
     * @parm path 文件路径
     */
    @Override
    public void readBigDataExcel(String path) throws Exception {
        // 1.根据excel报表获取OPCpackage
        OPCPackage opcPackage = OPCPackage.open(path, PackageAccess.READ);
        // 2.创建XSSFReader
        XSSFReader xssfReader = new XSSFReader(opcPackage);
        // 3.获取SharedStringTable对象
        SharedStringsTable sharedStringsTable = xssfReader.getSharedStringsTable();
        // 4.获取styleTable对象
        StylesTable stylesTable = xssfReader.getStylesTable();
        // 5.创建sax xmlReader对象
        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
        // 6.注册事件驱动处理器
        XSSFSheetXMLHandler xssfSheetXMLHandler = new XSSFSheetXMLHandler(stylesTable, sharedStringsTable, new SheetHandler(), false);
        xmlReader.setContentHandler(xssfSheetXMLHandler);
        // 7.逐行读取
        XSSFReader.SheetIterator sheetIterator = (XSSFReader.SheetIterator) xssfReader.getSheetsData();
        while (sheetIterator.hasNext()) {
            InputStream in = sheetIterator.next();
            InputSource is = new InputSource(in);
            xmlReader.parse(is);
        }
    }
}
