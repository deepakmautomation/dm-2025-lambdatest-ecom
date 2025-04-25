package com.dvm.qa.selenium.util;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderClass {

	@DataProvider(name="testDataProvider")
	public Object[][] getData() throws IOException {
		/*
		 * return new Object[][] { {"johnsmith@test.com", "Admin@123"},
		 * {"abcd@ymail.com", "pass2"} };
		 */
		
		Object[][] data  = getLoginDataFromExcel();
		
		return data;
	}

	public String[][] getLoginDataFromExcel() throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\dvm\\qa\\selenium\\testdata\\TestData.xlsx");

		XSSFSheet sheet = workbook.getSheet("login");

		int rows = sheet.getPhysicalNumberOfRows();

		int cols = sheet.getRow(0).getLastCellNum();
		
		String[][] loginData = new String[rows-1][cols];

		for(int i=0;i<rows;i++) {

			XSSFRow row =  sheet.getRow(i);

			for(int j=0;j<i;j++) {

				XSSFCell cell = row.getCell(j);
				
				switch (cell.getCellType()) {
				case STRING: loginData[i-1][j] = cell.getStringCellValue();
				break;
				case NUMERIC: loginData[i-1][j] =  String.valueOf(cell.getNumericCellValue());
				break;
				default:
				break;
				}
			}
		}
		
		workbook.close();
		return loginData;
	}

}
