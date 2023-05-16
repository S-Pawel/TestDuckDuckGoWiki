import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;

public class SaveToExel {
    public static void saveToXlsx(String[] testCaseTable, String[] testResults, String fileName) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Wyniki testów");

        Row headerRow = sheet.createRow(0);
        Cell testCaseCell = headerRow.createCell(0);
        testCaseCell.setCellValue("Użyty termin");
        Cell resultCell = headerRow.createCell(1);
        resultCell.setCellValue("Wynik testu");

        for (int i = 0; i < testCaseTable.length; i++) {
            Row row = sheet.createRow(i + 1);
            Cell testCaseValueCell = row.createCell(0);
            testCaseValueCell.setCellValue(testCaseTable[i]);
            Cell resultValueCell = row.createCell(1);
            resultValueCell.setCellValue(testResults[i]);
        }

        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            workbook.write(outputStream);
            System.out.println("Zapisano wyniki testów do pliku " + fileName);
        } catch (IOException e) {
            System.out.println("Błąd podczas zapisu do pliku " + fileName);
            e.printStackTrace();
        }
    }




}



