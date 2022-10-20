package Hello;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class NewData {
	

  @Test(dataProvider = "TestData")
  public void loginTest(String username, String password) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	   WebDriver driver=new ChromeDriver();
	driver.get("file:///C:/seleniumsoftware/Offline%20Website/Offline%20Website/index.html");
	driver.findElement(By.id("email")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.xpath("//button")).click();
	
  }

  @DataProvider
  public Object[][] TestData() throws Exception {
    FileInputStream file=new FileInputStream("dataprovied.xls");
        Workbook workbook=Workbook.getWorkbook(file);
        Sheet sh=workbook.getSheet("Sheet1");
       
          int rows=sh.getRows();
         int columes=sh.getColumns();
         String data[][]=new String[rows][columes];
          for (int i = 0; i <rows; i++) {
     	for (int j = 0; j <columes; j++) {
     	
     	Cell cell=sh.getCell(j,i);
     	 String value=cell.getContents();
     	 data[i][j]=value;
     	 
		}	
		} 
         return data;
  }
}
