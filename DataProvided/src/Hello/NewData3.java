package Hello;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class NewData3 {
  @Test(dataProvider = "logindata")
  public void f(String urname, String pass ,String title) {
	  System.setProperty("webdriver,chrome.driver","chromedriver.exe");
	  WebDriver driver=new ChromeDriver();
	  driver.get("file:///C:/seleniumsoftware/Offline%20Website/Offline%20Website/index.html");
	  driver.findElement(By.id("email")).sendKeys(urname);
	  driver.findElement(By.id("password")).sendKeys(pass);
	  driver.findElement(By.xpath("//button")).click();
	  Assert.assertEquals(driver.getTitle(), title);
  }

  @DataProvider
  public Object[][] logindata() throws Exception {
    FileInputStream file=new FileInputStream("emailpassword.data.xls");
     Workbook workbook =Workbook.getWorkbook(file);
     Sheet sheet=workbook.getSheet("Sheet1");
              int rows =sheet.getRows()  ;
              int columes=sheet.getColumns();
              String data[][]=new String[rows][columes];
              for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columes; j++) {
			Cell cell=	sheet.getCell(j, i);
			 String value=  cell.getContents();
			data[i][j]=value;
					
				}
			}
              return data;
              
    }
  

}
