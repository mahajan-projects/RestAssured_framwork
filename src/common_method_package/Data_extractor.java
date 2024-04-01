package common_method_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Data_extractor {

	public static ArrayList<String> getData(String filename,String sheetname,String tcname) throws IOException {
		
		ArrayList<String> excelDataArrayList=new ArrayList<String>();
		
		// Create Object of Json file input Stream with argument of location and name of excel file
	      FileInputStream fis = new FileInputStream("C:\\Users\\Mayuri Mahajan\\Desktop\\Mayuri_Evidence\\" + filename + ".xlsx");
		   
	// Create XSSF work book object with argument of file input string to open the excel file
		  XSSFWorkbook workbook = new XSSFWorkbook(fis);
			
	// Fetch the count of sheets available
		  int sheetCount = workbook.getNumberOfSheets();
			//System.out.println(sheetCount);
			
 //Fetch the sheet name for all files
	    for (int i = 0; i < sheetCount; i++) 
	    {
				String sheetName = workbook.getSheetName(i);
				//System.out.println(sheetName);
		if(sheetName.equalsIgnoreCase(sheetname)) 
		
		{
			XSSFSheet sheet=workbook.getSheetAt(i);
			
			//iterating rows
			Iterator<Row> rows=sheet.iterator();
			Row firstRow=rows.next();
			
			
			//Iterating cells
			Iterator<Cell> Cells=firstRow.cellIterator();
			int j=0;
			int tc_column=0;
			
			
			while (Cells.hasNext())
			
			
				{
				Cell Cell_value=Cells.next();
				//system.out.println(cell_values);
				//checking for the position of  attributeName column
				
				if(Cell_value.getStringCellValue().equalsIgnoreCase("tc_name"))
				{
					tc_column=j;
					System.out.println(tc_column);	
				}
				j++;
				}
			while(rows.hasNext()) 
			{
				Row r=rows.next();
				
				
				//checking all cell values for matching testcase name
				if(r.getCell(tc_column).getStringCellValue().equalsIgnoreCase(tcname))
			{
					Iterator<Cell> cellvalues=r.cellIterator();
					while(cellvalues.hasNext()) 
			{
						String test_data=cellvalues.next().getStringCellValue();
						System.out.println(test_data);
						excelDataArrayList.add(test_data);
			}
					
			}
			}
				
			}
		
		
	        }
		return excelDataArrayList;
	    }

	        }
