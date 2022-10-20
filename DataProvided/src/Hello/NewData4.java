package Hello;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class NewData4 {
  @Test(dataProvider = "data")
  public void f(String urname, String pass) {
	  System.setProperty("webdriver.chrome.driver","chromedriver");
	  WebDriver driver=new ChromeDriver();
	  driver.get("");
  }

  @DataProvider
  public Object[][] data() throws Exception {
    
     FileInputStream file=new FileInputStream("emailpassword.data.xls");
     Workbook workbook =Workbook.getWorkbook(file);
     Sheet sh=workbook.getSheet("Sheet1");
      int rows=sh.getRows();
      int columes=sh.getColumns();
      String data[][]=new String[rows][columes];
      for (int i = 0; i <rows; i++) {
      for (int j = 0; j <columes; j++) {
		Cell cell=sh.getCell(j, i);
	String value=cell.getContents();
    data[i][j]=value; 
	}
		
	}
      return data;
    }
  }

