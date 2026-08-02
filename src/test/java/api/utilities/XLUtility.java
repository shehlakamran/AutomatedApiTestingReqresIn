package api.utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XLUtility {
    public static FileInputStream fis;
    public static FileOutputStream fos;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;
    public static XSSFCell cell;
    String path;

    // public static XSSFCellStyle cellStyle;
    public XLUtility(String filepath) {
        this.path = filepath;
    }

    public int getRowCount(String filePath, String sheetName) throws IOException {
        fis = new FileInputStream(filePath);
        wb = new XSSFWorkbook(fis);
        ws = wb.getSheet(sheetName);
        int rowCount = ws.getLastRowNum();
        wb.close();
        fis.close();
        return rowCount;
    }

    public int getColumnCount(String filePath, String sheetName, int rownum) throws IOException {
        fis = new FileInputStream(filePath);
        wb = new XSSFWorkbook(fis);
        ws = wb.getSheet(sheetName);
        row = ws.getRow(rownum);
        int cellCount = row.getLastCellNum();
        wb.close();
        fis.close();
        return cellCount;
    }

    public String getCellData(String filePath, String sheetName, int rownum, int colnum) throws IOException {
        fis = new FileInputStream(filePath);
        wb = new XSSFWorkbook(fis);
        ws = wb.getSheet(sheetName);
        row = ws.getRow(rownum);
        cell = row.getCell(colnum);
        String data;
        try {
            //data=cell.toString();
            DataFormatter formatter = new DataFormatter();
            data = formatter.formatCellValue(cell);
        } catch (Exception e) {
            data = " ";
        }
        ;
        wb.close();
        fis.close();
        return data;
    }
}
