package POM;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class facebook_listeners implements ITestListener
{
public ExtentSparkReporter SR;
public ExtentReports Extent;
public ExtentTest test;

public void onStart(ITestContext context)
  {   
   SR=new ExtentSparkReporter(System.getProperty("user.dir")+"/docs/myreport3.html");
	 
	 SR.config().setDocumentTitle("automation testing");
	 SR.config().setReportName("functional testing");
	 SR.config().setTheme(Theme.DARK);
 
   Extent=new ExtentReports();
   Extent.attachReporter(SR);
   Extent.setSystemInfo("computername",    "dell");
   Extent.setSystemInfo("Environment" ,      "QA");
   Extent.setSystemInfo( "testername" , "nagaraj");
   Extent.setSystemInfo(        " Os" ,   "linux");
   Extent.setSystemInfo("browserName" ,  "chrome");  }
public void onTestSuccess(ITestResult result)
{
	 test=Extent.createTest(result.getName());//crete new entry in the report
	 test.log(Status.PASS, "passed testcase is: "+result.getName());
	
}
public void onTestFailure(ITestResult result)
{
	
	test=Extent.createTest(result.getName());
	test.log(Status.FAIL,"failed test case is: "+ result.getName());
	test.log(Status.FAIL,"test case is failed because of:"+result.getThrowable());
}
public void onTestSkipped(ITestResult result)
{
	test=Extent.createTest(result.getName());
	test.log(Status.SKIP, "test case is skipped: "+ result.getName());
}
public void onFinish(ITestContext context) 
{
	Extent.flush();
}
}
