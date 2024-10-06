package org.myProject.listeners;


import org.myProject.reportManager.ExtentLogger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import static org.myProject.configManager.ConfigFactory.getConfig;

public class Retry implements IRetryAnalyzer {

    private static final int maxRetryCount = getConfig().retryCounter();  // Fetch retry count from config
    private int retryCount = 0;


    @Override
    public boolean retry(final ITestResult iTestResult) {
        if (retryCount < maxRetryCount) {
            logRetry(iTestResult);
            retryCount++;
            return true;
        }
        return false;
    }

    // Method to log retry attempts
    private void logRetry(final ITestResult iTestResult) {
        String message = String.format("Retrying test %s with status %s for the %d time(s).",
                iTestResult.getName(),
                getResultStatusName(iTestResult.getStatus()),
                retryCount + 1);
        ExtentLogger.testLabel(message);  // Example for logging, replace as needed
    }

    // Method to get human-readable result status
    private String getResultStatusName(final int status) {
        switch (status) {
            case ITestResult.SUCCESS:
                return "SUCCESS";
            case ITestResult.FAILURE:
                return "FAILURE";
            case ITestResult.SKIP:
                return "SKIPPED";
            default:
                return "UNKNOWN";
        }
    }
}