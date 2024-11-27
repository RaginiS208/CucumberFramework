package Utilities;



import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class ExtentManager {
	
	 

    public static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
        reporter.config().setReportName("BDDCucumberFramework Extent Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Proj Name", "BDD Framework");
        extentReports.setSystemInfo("Author", "Ragini Soneri");
        return extentReports;
    }
}