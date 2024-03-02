package ExcelUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelInputUtils {
	
	public static  XSSFSheet Sheet1 ;
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;   
	public static String path = System.getProperty("user.dir")+"\\testData\\corporateDetails.xlsx";
	public static List<String>Mydata=new ArrayList<String>();
	public static List<String>Mydata2=new ArrayList<String>();
	

	public static List<String> InvalidData()throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet("Sheet1");
		
	
		for (int i=1;i<=4;i++) {
			if(i==3) {
				
				String cellData=(""+(long) ws.getRow(2).getCell(i).getNumericCellValue());
				Mydata.add(cellData);
			}
			else {
			String cellData=ws.getRow(2).getCell(i).toString();
			Mydata.add(cellData);
			}
		}
		wb.close();
		fi.close();
		return Mydata;
		
		
	}
	public static List<String> validData()throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet("Sheet1");
		
	
		for (int i=1;i<=4;i++) {
			if(i==3) {
				
				String cellData2=(""+(long) ws.getRow(3).getCell(i).getNumericCellValue());
				Mydata2.add(cellData2);
			}
			else {
			String cellData2=ws.getRow(3).getCell(i).toString();
			Mydata2.add(cellData2);
			}
		}
		wb.close();
		fi.close();
		return Mydata2;
		
		
	}
}
	


