import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExelReader {


    public static String[] readExel(String fileName) throws IOException {
        File file= new File("src/test/resources/" + fileName);
        FileInputStream inputStream = new FileInputStream(file);

        Workbook workbook = null;
        String fileExt = fileName.substring(fileName.indexOf("."));
        if(fileExt.equals(".xlsx")){
            workbook = new XSSFWorkbook(inputStream);
        } else if(fileExt.equals(".xls")){
            workbook = new HSSFWorkbook(inputStream);
        }
        assert workbook != null;
        Sheet sheet = workbook.getSheetAt(0);
        int rowCount = sheet.getLastRowNum();
        String[] data = new String[rowCount+1];

        for(int i=0; i<=rowCount; i++){
            Row row = sheet.getRow(i);
            String cellValue = row.getCell(0).getStringCellValue();
            data[i] = cellValue;

        }
        System.out.println(data[0]);
        return data;

    }

}