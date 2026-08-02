package api;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportListener implements ITestListener {

    private ExtentReports extent;
    private ExtentTest test;
    private ExtentSparkReporter sparkReporter;
    private String reportName;

    @Override
    public void onStart(ITestContext context) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        reportName = "Test-Report-" + sdf.format(new Date()) + ".html";

        String reportPath = System.getProperty("user.dir") + "/reports/" + reportName;

        sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setDocumentTitle("API Automation Report");
        sparkReporter.config().setReportName("Rest Assured Execution Report");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Tester", "Shehla");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Framework", "Rest Assured + TestNG");
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, result.getName() + " passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, result.getName() + " failed");
        test.log(Status.FAIL, result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, result.getName() + " skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();

        File reportFile = new File(System.getProperty("user.dir") + "/reports/" + reportName);
        try {
            Desktop.getDesktop().browse(reportFile.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
