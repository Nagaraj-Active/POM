package POM;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Fb_listners implements ITestListener
{
 public ExtentSparkReporter es;
 public ExtentReports er;
 public ExtentTest et;
public void onStart(ITestContext context)
{
	es=new ExtentSparkReporter(System.getProperty("user.dir")+"/docs/fb12.html");
   
	es.config().setDocumentTitle("automation_fb");
	es.config().setReportName("smoke");
	es.config().setTheme(Theme.STANDARD);
	
	er=new ExtentReports();
	er.attachReporter(es);
	er.setSystemInfo("computer name", "dell");
    er.setSystemInfo("environment","QA");
    er.setSystemInfo("os", "ubantu");
    er.setSystemInfo("tester name", "nagaraj");
}
public void onTestSuccess(ITestResult result)
{
	et=er.createTest(result.getName());
	et.log(Status.PASS,"Passed test case is: "+result.getName());
}
public void onTestFailure(ITestResult result)
{
	et=er.createTest(result.getName());
	et.log(Status.FAIL,"failed test case is: "+result.getName());
}
public void onTestSkipped(ITestResult result)
{
	et=er.createTest(result.getName());
	et.log(Status.SKIP,"skipped test case is: "+result.getName());
}
public void onFinish(ITestContext context)
{
	er.flush();
}
}
