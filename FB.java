package POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(POM.Fb_listners.class)
public class FB 
{
WebDriver driver;
FB_fctr_POM fl;
@BeforeTest
void setup()
   {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    fl=new FB_fctr_POM(driver);    
   }
@Test
 void logo_is_present()
 {
	 Assert.assertEquals(fl.logocheck(), true);
 }
@Test
 void login()
 {
	 fl.pass_emailid("autotesting842@gmail.com");
	 fl.pass_pwd("Nagu@123");
	 fl.click_btn();
	 
 }
 @AfterClass
 void teardown()
 {
	 driver.quit();
 }
}
