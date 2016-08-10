package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	configDataProvider dataProvider;
	public ExcelDataProvider()	
	{
	   File f=new File(System.getProperty("user.dir")+dataProvider.getvalue("ExcelFilePath"));
	   FileInputStream fis;
	try {
		fis = new FileInputStream(f);
		 wb=new XSSFWorkbook(fis);
		} 
	catch (Exception e) 
	{
		System.out.println(e.getMessage());
	}
	   
	}
	
	public String getdata(int sheetindex, int row, int column)
	{
		sheet=wb.getSheetAt(sheetindex);
		return sheet.getRow(row).getCell(column).toString();
	}
	
	public String getdata(String sheetname, int row, int column)
	{
		sheet=wb.getSheet(sheetname);
		return sheet.getRow(row).getCell(column).toString();
	}
	

}