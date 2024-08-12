package com.BookWagon.Test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.BookWagon.Base.BWloginbaseclass;
import com.BookWagon.page.BWloginPage;



public class BWloginTest extends BWloginbaseclass{
	
	@Test
	public void logintest () throws IOException, InterruptedException 
	{
		
		BWloginPage log=new BWloginPage(driver);
		
		
		
			FileInputStream f=new FileInputStream(".\\TestData\\Bookwagon.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(f);
			XSSFSheet sh=wb.getSheet("sheet1");
			int row=sh.getLastRowNum();
			for(int i=1;i<=row;i++)
				
			{
				String un=sh.getRow(i).getCell(0).getRawValue();
				String pswd=sh.getRow(i).getCell(1).getStringCellValue();
				System.out.println("username="+un +"password="+pswd);
				log.login(un, pswd);
				
				String exptdurl="https://www.bookswagon.com/myaccount.aspx";
				String acturl=driver.getCurrentUrl();
				if(exptdurl.equals(acturl))
				{
					System.out.println("log in succes");
				}
				else
				{
					System.out.println("log in fail");
				}
		}
		
	}

	}
