package org.myProject.reportManager;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.myProject.utils.ReusableMethods;
import org.openqa.selenium.WebElement;

public class  ExtentLogger {
    private ExtentLogger() {

    }
    public static void pass(String message) {
        ExtentReportDriver.getInstance().getExtent().pass(message);
    }
    public static void pass(Markup message) {
          ExtentReportDriver.getInstance().getExtent().pass(message);
    }
    public static void fail(String message) {
        ExtentReportDriver.getInstance().getExtent().fail(message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(ReusableMethods.getBase64Image()).build());    }
    public static void fail(String message, WebElement element) {
        ExtentReportDriver.getInstance().getExtent().fail(message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(ReusableMethods.getBase64ElementImage(element)).build());    }

    public static void fail(Markup message) {
          ExtentReportDriver.getInstance().getExtent().fail(message);
    }
    public static void error(String message) {
        ExtentReportDriver.getInstance().getExtent().fail(message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(ReusableMethods.getBase64Image()).build());    }

    public static void skip(String message) {
          ExtentReportDriver.getInstance().getExtent().skip(message);
    }

    public static void warn(String message) {
          ExtentReportDriver.getInstance().getExtent().warning(message);
    }

    public static void skip(Markup message) {
          ExtentReportDriver.getInstance().getExtent().skip(message);
    }

    public static void info(Markup message) {
          ExtentReportDriver.getInstance().getExtent().info(message);
    }

    public static void info(String message) {
          ExtentReportDriver.getInstance().getExtent().info(message);
    }
    public static synchronized void testLabel(String log) {
        com.aventstack.extentreports.ExtentTest test = ExtentReportDriver.getInstance().getExtent();
        test.log(Status.INFO, MarkupHelper.createLabel("Performing -> " + log, ExtentColor.CYAN));
    }
    public static synchronized void addScreenshot(String message) {
        ExtentReportDriver.getInstance().getExtent().info(message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(ReusableMethods.getBase64Image()).build());    }
}
