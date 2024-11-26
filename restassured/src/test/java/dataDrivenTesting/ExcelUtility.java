package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	String testdata="./src/test/resources/restassured_testdata.xlsx";
	public String getDataFromExcel(String sheetname,int rownum,int celnum) throws Throwable {
		FileInputStream fis=new FileInputStream(testdata);
		Workbook wb=WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetname).getRow(rownum).getCell(celnum).getStringCellValue();
		wb.close();
		return data;
	}
	public int getRowcount(String sheetname) throws Throwable {
		FileInputStream fis=new FileInputStream(testdata);
		Workbook wb=WorkbookFactory.create(fis);
		int rowcount=wb.getSheet(sheetname).getLastRowNum();
		wb.close();
		return rowcount;
	}
	public void setDataIntoExcel(String sheetname,int rownum,int celnum,String data) throws Throwable {
		FileInputStream fis=new FileInputStream(testdata);
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetname).getRow(rownum).createCell(celnum);
		FileOutputStream fos = new FileOutputStream(testdata);
		wb.write(fos);
		wb.close();
	}
}
