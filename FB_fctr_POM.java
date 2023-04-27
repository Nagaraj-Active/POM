package POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FB_fctr_POM
{
    WebDriver driver;
    FB_fctr_POM(WebDriver driver)
    { 
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
    }
    
    //WebElement locators
    @FindBy(xpath="//input[@name='email']")   WebElement email_txt;
    @FindBy(xpath="//input[@type='password']")  WebElement pwd_txt;
    @FindBy(xpath="//button[@name='login']") WebElement submit_btn;
    @FindBy(xpath="//img[@alt='Facebook']")        WebElement logo;

    
    //Action
    public void pass_emailid(String email)
    {
    	email_txt.sendKeys(email);
    }
    public void pass_pwd(String password)
    {
    	pwd_txt.sendKeys(password);
    }
    public void click_btn()
    {
    	submit_btn.click();
    }
    public boolean logocheck()
    {
    	boolean fb = logo.isDisplayed();
    	return fb;
    }
    
} 
