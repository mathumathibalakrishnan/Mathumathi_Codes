package mathu.motv.CW;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;



public class ExtentTestManager {
	static Map extentTestMap = new HashMap();
    static ExtentReports extent = ExtentReports.getReporter();
 
    public static synchronized ExtentTest getTest() {
        return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }
 
    public static synchronized void endTest() {
        extent.endTest((ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId())));
    }
 
    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extent.startTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }
	
	
	
	
	
	
	
	
	
	
	
}
