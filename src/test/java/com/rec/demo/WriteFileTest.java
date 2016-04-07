package com.rec.demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class WriteFileTest {

	private static final String FILENAME = "output.xlsx";

	@Test
	public void write() throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		XSSFRow row = sheet.createRow(0);

		row.createCell(0).setCellValue("abc");

		row.createCell(1).setCellValue(1.2);

		XSSFCell cell = row.createCell(2);
		cell.setCellValue(new Date());
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setDataFormat(workbook.createDataFormat().getFormat("dd-MM-yyyy"));
		cell.setCellStyle(cellStyle);

		row.createCell(3).setCellValue(true);

		FileOutputStream fout = new FileOutputStream(FILENAME);
		workbook.write(fout);
		workbook.close();
	}

}
