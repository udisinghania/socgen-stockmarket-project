package com.stockmarket.excelservice.helper;

import com.stockmarket.excelservice.entities.Stock;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {

    public static List<Stock> excelToStocks(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            List<Stock> stocks = new ArrayList<Stock>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                Stock stock = new Stock();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {
                        case 1:
                            stock.setCompanyCode(currentCell.getStringCellValue());
                            break;
                        case 2:
                            RestTemplate restTemplate = new RestTemplate();
                            String url = "http://localhost:9090/stockexchange/stockexchanges/name";
                            ResponseEntity<Integer> response = restTemplate.getForEntity(url + "/"+currentCell.getStringCellValue(), Integer.class);
                            int id = response.getBody();
                            stock.setStockExchangeId(7);
                            break;
                        case 3:
                            stock.setPrice(currentCell.getNumericCellValue());
                            break;
                        case 4:
                            stock.setDate(currentCell.getStringCellValue());
                            break;
                        case 5:
                            stock.setTime(currentCell.getStringCellValue());
                            break;
                        default:
                            break;
                    }

                    cellIdx++;
                }

                stocks.add(stock);
            }

            workbook.close();

            return stocks;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}
