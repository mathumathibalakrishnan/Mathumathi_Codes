package mathu.motv.CW;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtentManager {

	private static ExtentReports extent;


	public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            //Set HTML reporting file location
            String workingDir = "/CW";
            extent = new ExtentReports();
        }
        return extent;
    }

	
}
