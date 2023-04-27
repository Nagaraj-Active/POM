package POM;

import java.awt.Window;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(POM.facebook_listeners.class)
@Test
public class facebook 
 {
     WebDriver driver;
     facebook_POM pl;
     @BeforeClass	
     void setup()
      {
    	WebDriverManager.chromedriver().setup();
    	driver=new ChromeDriver();
        pl=new facebook_POM(driver);	
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      }
     @Test
     void components_check()
      {
    	
    	Assert.assertEquals(pl.Enable_Link(), true);
      }
     @Test
     void check_button_Enable()
      {
        Assert.assertEquals(pl.Enable_Button(), true);
      }
     @Test
     void login()
      {
    	pl.username("rajmannale@gmail.com");
    	pl.pwd("Nagu@123");
    	pl.submt();
      }
     @AfterClass
     void teardown()
     {
    	 driver.quit();
     }
 }
