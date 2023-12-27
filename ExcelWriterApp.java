import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ExcelWriterApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Create a new Excel workbook
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Credentials");

            // Create a new row and set values
            Row row = sheet.createRow(0);
            row.createCell(0).setCellValue("Username");
            row.createCell(1).setCellValue(username);

            row = sheet.createRow(1);
            row.createCell(0).setCellValue("Password");
            row.createCell(1).setCellValue(password);

            // Write the workbook to an Excel file
            try (FileOutputStream fos = new FileOutputStream("credentials.xlsx")) {
                workbook.write(fos);
                System.out.println("Credentials saved to credentials.xlsx");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
