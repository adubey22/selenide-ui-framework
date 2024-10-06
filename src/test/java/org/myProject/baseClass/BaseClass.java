package org.myProject.baseClass;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.myProject.pageObject.LandingPage;
import org.myProject.pageObject.LoginPage;
import org.myProject.reportManager.ExtentLogger;
import org.myProject.reportManager.ExtentReportDriver;
import org.myProject.reportManager.ExtentReportNG;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.myProject.configManager.ConfigFactory.getConfig;
import static org.myProject.frameworkComstants.Constants.DOWNLOAD_DIRECTORY;
import static org.myProject.frameworkComstants.Constants.WORKING_DIRECTORY;
import static org.myProject.frameworkComstants.ReportConstants.*;
import static org.myProject.userActions.CustomActions.openUrl;

public class BaseClass {
    private static final Logger logger = LoggerFactory.getLogger(BaseClass.class);

    protected static LandingPage landingPage;
    protected static LoginPage loginPage;


    @BeforeSuite(alwaysRun = true)
    public void setUpSuite() throws IOException {
        logger.info("Setting up test suite");
        logger.info("Setting up test suite with browser: " + getConfig().browserName());
        logger.info("Setting up test suite with headless mode: " + getConfig().isHeadless());
        logger.info("Setting up test suite with browser version: " + getConfig().environment());
        configureSelenide();
        initializeExtentReports();
        printOSName();
    }

    @BeforeClass(alwaysRun = true)
    public void setUpTest() {
        logger.info("Setting up test");
        initializePageObjects();
        logger.info("Setting up test with browser: " + getConfig().browserName());
    }

    @BeforeMethod(alwaysRun = true)
    public void startTest(ITestResult iTestResult) {
        ExtentReportNG.createTest(iTestResult.getMethod().getMethodName());
        logger.info("Starting test: " + iTestResult.getMethod().getMethodName());
        ExtentLogger.info("Starting test: " + iTestResult.getMethod().getMethodName());
        openUrl("/");
        logTestStart(iTestResult);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult iTestResult) {
        handleTestResult(iTestResult);
        getWebDriver().quit();
    }

    @AfterClass(alwaysRun = true)
    public static void tearDownAll() {
        // Not used in the provided code, can be added for specific cleanup
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownSuite() {
        ExtentReportNG.flushReports();
    }

    private void logTestStart(ITestResult iTestResult) {
        ExtentLogger.info("Thread: " + Thread.currentThread().getId() + ", Driver: " + getWebDriver().getClass().getSimpleName());
        ExtentLogger.testLabel("Test Case: [" + iTestResult.getMethod().getMethodName() + "] started!");
    }

    private void handleTestResult(ITestResult iTestResult) {
        switch (iTestResult.getStatus()) {
            case ITestResult.FAILURE:
                logFailure(iTestResult);
                break;
            case ITestResult.SUCCESS:
                logSuccess(iTestResult);
                break;
            case ITestResult.SKIP:
                logSkip(iTestResult);
                break;
        }
    }

    private void logFailure(ITestResult iTestResult) {
        ExtentReportDriver.getInstance().getExtent().log(Status.FAIL, "Test case: [" + iTestResult.getMethod().getMethodName() + "] failed with failure percentage: " + iTestResult.getMethod().getSuccessPercentage());
        ExtentReportDriver.getInstance().getExtent().log(Status.FAIL, iTestResult.getThrowable());
        try {
            ExtentReportNG.addScreenShot(Status.FAIL, iTestResult.getMethod().getMethodName());
            String logText = "<b>" + iTestResult.getMethod().getMethodName() + " failed.</b>" + "  " + ICON_SMILEY_FAIL;
            Markup markupMessage = MarkupHelper.createLabel(logText, ExtentColor.RED);
            ExtentLogger.fail(markupMessage);
            byte[] screenshot = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("failed_test_screenshot", new ByteArrayInputStream(screenshot));
            ExtentReportDriver.getInstance().removeExtent();
        } catch (Exception e) {
            e.fillInStackTrace();
        }

    }

    private void logSuccess(ITestResult iTestResult) {
        ExtentReportDriver.getInstance().getExtent().log(Status.PASS, "Test case: [" + iTestResult.getMethod().getMethodName() + "] passed with success percentage : " + iTestResult.getMethod().getSuccessPercentage());
        String logText = "<b>" + iTestResult.getMethod().getMethodName() + " passed.</b>" + "  " + ICON_SMILEY_PASS;
        Markup markupMessage = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        ExtentLogger.pass(markupMessage);
        ExtentReportDriver.getInstance().removeExtent();
    }

    private void logSkip(ITestResult iTestResult) {
        ExtentReportDriver.getInstance().getExtent().log(Status.SKIP, "Test case: " + iTestResult.getName() + " skipped with success percentage: " + iTestResult.getMethod().getSuccessPercentage());
        ExtentReportDriver.getInstance().getExtent().log(Status.SKIP, iTestResult.getThrowable());
        ExtentReportNG.addScreenShot(Status.SKIP, iTestResult.getMethod().getMethodName());
        String logText = "<b>" + iTestResult.getMethod().getMethodName() + " skipped.</b>" + "  " + ICON_SMILEY_SKIP;
        Markup markupMessage = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
        ExtentLogger.skip(markupMessage);
        ExtentReportDriver.getInstance().removeExtent();
    }

    private void printOSName() {
        String osName = System.getProperty("os.name");
        System.out.println("Operating System Name: " + osName);
        if (osName.equalsIgnoreCase("Linux")) {
            System.setProperty("webdriver.chrome.driver", WORKING_DIRECTORY + "/src/test/resources/browserDrivers/chromedriver");
        }
    }

    private void initializeExtentReports() {
        try {
            ExtentReportNG.extentReportSetup();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void configureSelenide() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        System.setProperty("allure.results.directory", "target/allure-results");
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.media_stream_camera", 1);
        prefs.put("profile.default_content_setting_values.media_stream_mic", 1);
        prefs.put("download.default_directory", DOWNLOAD_DIRECTORY);
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.prompt_for_download", false);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        Configuration.browser = "chrome";
        Configuration.baseUrl = getConfig().url();
        Configuration.pageLoadStrategy = "normal";
        Configuration.reportsFolder = "target/test-result/reports";
        Configuration.timeout = 30000;
        Configuration.headless = getConfig().isHeadless();
        Configuration.fastSetValue = true;
        Configuration.browserSize = "1280x800";
        Configuration.browserCapabilities = new ChromeOptions()
                .addArguments("--remote-allow-origins=*")
                .addArguments("--start-maximized")
                .setExperimentalOption("prefs", prefs);
        Configuration.pageLoadTimeout = 60000;
        Configuration.savePageSource = false;
    }

    private static void initializePageObjects() {
        loginPage = new LoginPage();
        landingPage = new LandingPage();
    }
}