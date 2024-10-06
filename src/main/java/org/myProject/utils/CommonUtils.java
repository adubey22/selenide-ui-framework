package org.myProject.utils;

import com.codeborne.selenide.Selenide;
import org.myProject.reportManager.ExtentLogger;
import org.myProject.reportManager.ExtentReportDriver;


public class CommonUtils {

    // Method to capture screenshot and attach to Extent Report
    public static void captureScreenshotAndAttachToReport(String screenshotName) {
        // Capture the screenshot and get the file path
        String screenshotPath = Selenide.screenshot(screenshotName);
        // Attach the screenshot to Extent Report
        ExtentLogger.info("Screenshot attached: " + screenshotPath);
        ExtentReportDriver.getInstance().getExtent().addScreenCaptureFromPath(screenshotPath);
    }
}
