package utilities;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
public class excelreader {
	private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;
	public static void setexcelfile(String Path) throws Exception{
		 FileInputStream ExcelFile = new FileInputStream(Path);
         ExcelWBook = new XSSFWorkbook(ExcelFile);
        
	}
	
	public static int getrownumber(String SheetName){
        ExcelWSheet = ExcelWBook.getSheet(SheetName);
		int row = ExcelWSheet.getPhysicalNumberOfRows();
		return row;
	}
	public static String getCellData(int RowNum, int ColNum, String SheetName) throws Exception{
        ExcelWSheet = ExcelWBook.getSheet(SheetName);
        
        	Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
	        String CellData = Cell.getStringCellValue();
	        return CellData;
	       
	        
	}
	  	 
  	  
}
