package Util;

import Bean.ExcelRecord;
import Bean.ResponseBody;
import Bean.ResponseBodyGuava;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class ExcelUtil {
    private static final String testExcelPathUrl = "AutoReqData.xls";

    public static void startExcel(ResponseBody rb, ResponseBodyGuava rbg) {

        File file = new File(testExcelPathUrl);

        if (file.exists()) {
            writingExcel(rb, rbg);
        } else {
            createExcel(rb, rbg);
        }
    }

    public static void createExcel(ResponseBody responseBody, ResponseBodyGuava responseBodyGuava) {

        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            FileOutputStream fileOutputStream = new FileOutputStream(new File(testExcelPathUrl));

            HSSFSheet spreadSheet = workbook.createSheet("Records");
            String[] columnHeadings = {"Request Id", "Amount from RFI API", "Amount from Guava API", "Date"};
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 12);
            headerFont.setColor(IndexedColors.BLACK.index);


            HSSFCellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFont(headerFont);
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);

            HSSFRow headerRow = spreadSheet.createRow(0);
            for (int i = 0; i < columnHeadings.length; i++) {
                HSSFCell cell = headerRow.createCell(i);
                cell.setCellValue(columnHeadings[i]);
                cell.setCellStyle(headerStyle);
            }

            spreadSheet.createFreezePane(0, 1);


            ArrayList<ExcelRecord> excelRecordArrayList = createData(1, responseBody.getAmount(), responseBodyGuava.getAvailable_amount());
            ExcelRecord exre = excelRecordArrayList.get(0);

            System.out.println();
            System.out.println("Final Result ");
            System.out.println("Request Id: 1");
            System.out.println("Amount from RFI API: "+exre.getAmountFromRFI());
            System.out.println("Amount from GUAVA API: "+exre.getAmountFromGuava());
            System.out.println("Date: "+new Date());

            int rowNum = 1;
            for (ExcelRecord er : excelRecordArrayList) {
                try {
                    HSSFRow row = spreadSheet.createRow(rowNum++);
                    row.createCell(0).setCellValue(er.getRequestId());
                    row.createCell(1).setCellValue(er.getAmountFromRFI());
                    row.createCell(2).setCellValue(er.getAmountFromGuava());
                    row.createCell(3).setCellValue(er.getDate().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }


            for (int i = 0; i < columnHeadings.length; i++) {
                spreadSheet.autoSizeColumn(i);
            }

            Sheet sh2 = workbook.createSheet("Second Records Sheet");
            File excelFile = new File(testExcelPathUrl);
            FileOutputStream fileOut = new FileOutputStream(excelFile);

            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("Excel file exported successfully");
            System.out.println("--------------------------------------------");
            System.out.println();
        } catch (Exception e) {
            if (e == null) {
                System.out.println("Done");
            } else {
                e.printStackTrace();
            }
        }
    }

    private static ArrayList<ExcelRecord> createData(int rId, int amountFromRFI, String amountFromGuava) throws Exception {
        ArrayList<ExcelRecord> a = new ArrayList<ExcelRecord>();
        a.add(new ExcelRecord(rId, amountFromRFI, amountFromGuava, new Date()));

        return a;
    }

    public static void writingExcel(ResponseBody resB, ResponseBodyGuava resBG) {
        try {

            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(testExcelPathUrl));
            HSSFSheet sheet = workbook.getSheetAt(0);

            //getting last row and cell value
            int lastRowNum = sheet.getLastRowNum();
            HSSFRow r = sheet.getRow(lastRowNum);
            int cn = (int) r.getCell(0).getNumericCellValue();
            int currentRid = cn+1;
            ArrayList<ExcelRecord> excelRecordArrayList1 = createData(currentRid, resB.getAmount(), resBG.getAvailable_amount());
            ExcelRecord exre = excelRecordArrayList1.get(0);
            System.out.println();
            System.out.println("Final Result ");
            System.out.println("Request Id: "+currentRid);
            System.out.println();
            System.out.println("Amount from RFI API: "+exre.getAmountFromRFI());
            System.out.println("Moscow Date : "+ LocalDateTime.now(ZoneId.of("Europe/Moscow")).format(DateTimeFormatter.ofPattern("d.MM.yyyy HH:mm")));
            System.out.println();
            System.out.println("Amount from GUAVA API: "+exre.getAmountFromGuava());
            System.out.println("Baku Date: "+new Date());
            System.out.println();

            int rowNum = sheet.getLastRowNum() + 1;
            for (ExcelRecord er : excelRecordArrayList1) {
                HSSFRow row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(er.getRequestId());
                row.createCell(1).setCellValue(er.getAmountFromRFI());
                row.createCell(2).setCellValue(er.getAmountFromGuava());
                row.createCell(3).setCellValue(er.getDate().toString());

            }

            File currentExcelFile = new File(testExcelPathUrl);
            FileOutputStream fileOut = new FileOutputStream(currentExcelFile);

            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("Excel file updated successfully");
            System.out.println("--------------------------------------------");
            System.out.println();


        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }
}
