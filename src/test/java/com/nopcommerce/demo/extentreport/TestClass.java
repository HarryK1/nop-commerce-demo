package com.nopcommerce.demo.extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TestClass {

    @Test
    public void extentTest() throws IOException {
        //create the object of extent report
        ExtentReports reports = new ExtentReports();
        //spark reporter
        ExtentSparkReporter spark = new ExtentSparkReporter("extent.html");// html file will be generated
        //report theme, report title and report name
        spark.config().setTheme(Theme.DARK);
        spark.config().setReportName("Nope Commerce");
        spark.config().setDocumentTitle("Automation");


        //attach the spark to report
        reports.attachReporter(spark);

        //add system information
        reports.setSystemInfo("OS", System.getProperty("os.name"));
        reports.setSystemInfo("Java version", System.getProperty("java.version"));
        reports.setSystemInfo("Browser", "Chrome");
        reports.setSystemInfo("Browser Version", "119.1.2");

        //create the test

        ExtentTest test =reports.createTest("Login Test").assignAuthor("Jay").assignCategory("Smoke");
        test.pass("Login Test start successfully");
        test.info("Url is loaded");
        test.info("Values entered");
        test.pass("Login test completed successfully");
        //how to highlight the step
        test.pass(MarkupHelper.createLabel("Login test completed successfully", ExtentColor.GREEN));

        ExtentTest test1 =reports.createTest("Homepage Test").assignAuthor("Prime").assignCategory("Sanity");
        test1.pass("Homepage Test start successfully");
        test1.info("Url is loaded");
        test1.info("Values entered");
        test1.pass("Homepage test completed successfully");
        //how to highlight in red
        test1.fail(MarkupHelper.createLabel("Homepage test failed", ExtentColor.RED));

        reports.flush(); // unless you can call this method report will not be written the logs
        Desktop.getDesktop().browse(new File("extent.html").toURI()); // this will open the file in the desktop default browser
    }
}


