package Hello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewTest {
  @Test(dataProvider = "dp")
  public void f(String urname, String password,String title) {
	  System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
	  WebDriver driver=new ChromeDriver();
	  driver.get("file:///C:/seleniumsoftware/Offline%20Website/Offline%20Website/index.html");
	  driver.findElement(By.id("Email")).sendKeys(urname);
	  driver.findElement(By.id("password")).sendKeys(urname);
	  driver.findElement(By.xpath("//button")).click();
	  Assert.assertEquals(driver.getTitle(), title);
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "kiran2gmail.com", "123456","JavaByKiran  |  Dashbord "},
      new Object[] { "sumit@gmail.com", "baxasx","JavaByKiran  |  Log in " },
      new Object[] { "ganu@gmail.com", "baxasx","JavaByKiran  |  Log in " },
      new Object[] { "suraj@gmail.com", "12313","JavaByKiran  |  Log in " },
      new Object[] { "omakr@gmail.com", "sadad","JavaByKiran  |  Log in " },
    };
  }
}
