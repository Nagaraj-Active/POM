package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class facebook_POM 
{
 WebDriver driver;
 facebook_POM(WebDriver driver)
 {
	 this.driver=driver;
 }
 //locators
 
 By username=By.xpath("//input[@name='email']");
 By pwd=By.xpath("//input[@name='pass']");
 By submit=By.xpath("//button[@name='login']");
 By C_button=By.xpath("(//a[@role=\"button\"])[2]");
 By link=By.xpath("//a[.='Forgotten password?']");
//public Boolean btn;

 
 //Action class
 public boolean Enable_Button()
 {
	boolean btn=driver.findElement(C_button).isEnabled();
	return btn;
 }
 public boolean Enable_Link()
 {
	 boolean lnk=driver.findElement(link).isEnabled();
     return lnk;
 }
 public void username(String usrname)
 {
	 driver.findElement(username).sendKeys(usrname);
 }
 public void pwd(String password)
 {
	 driver.findElement(pwd).sendKeys(password);
 }
 public void submt()
 {
	 driver.findElement(submit).click();
 }
 
 
}
